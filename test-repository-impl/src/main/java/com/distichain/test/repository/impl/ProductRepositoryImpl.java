package com.distichain.test.repository.impl;

import com.distichain.test.bo.ProductBo;
import com.distichain.test.common.ResponseCode;
import com.distichain.test.exception.ProductException;
import com.distichain.test.repository.ProductRepository;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ProductRepositoryImpl implements ProductRepository {

    private static final String FILE = "./Products.csv";

    @Async
    @Override
    public void save(List<ProductBo> products)  {
        try {
            
            CSVWriter writer = new CSVWriter(new FileWriter(FILE, true));
            ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
            mappingStrategy.setType(ProductBo.class);

            String[] columns = new String[] { "Sku", "Title", "Description", "Price", "Quantity" };
            mappingStrategy.setColumnMapping(columns);

            StatefulBeanToCsvBuilder<ProductBo> builder= new StatefulBeanToCsvBuilder(writer);
            StatefulBeanToCsv beanWriter = builder.withMappingStrategy(mappingStrategy).build();

            beanWriter.write(products);
            writer.flush();
            writer.close();
        }catch (Exception ex) {
            throw new ProductException(ResponseCode.TECHNICAL_ERROR, "Error during write on file ");
        }
    }

    @Override
    public Optional<ProductBo> findBySku(String sku) {
        try {
            List<ProductBo> list = new CsvToBeanBuilder<ProductBo>(new FileReader(FILE))
                    .withType(ProductBo.class)
                    .build()
                    .parse();
            Optional<ProductBo> productBo = list.stream().filter(e -> sku.equals(e.getSku())).findFirst();
            return productBo;
        }catch (Exception ex) {
            throw new ProductException(ResponseCode.TECHNICAL_ERROR, "Error during read from file ");
        }
    }

    @Override
    public List<ProductBo> findAll() {
        try {
            List<ProductBo> list = new CsvToBeanBuilder<ProductBo>(new FileReader(FILE))
                    .withType(ProductBo.class)
                    .build()
                    .parse();
            return list;
        } catch (FileNotFoundException ex) {
            log.warn("File not found");
            return new ArrayList<>();
        } catch (Exception ex) {
            throw new ProductException(ResponseCode.TECHNICAL_ERROR, "Error during read from file ");
        }
    }

    @Override
    public ProductBo update(ProductBo productBo) {
        try {
            List<ProductBo> list = new CsvToBeanBuilder<ProductBo>(new FileReader(FILE))
                    .withType(ProductBo.class)
                    .build()
                    .parse();
            Optional<ProductBo> product = list.stream().filter(e -> productBo.getSku().equals(e.getSku())).findFirst();
            list.remove(product.get());
            list.add(productBo);

            CSVWriter writer = new CSVWriter(new FileWriter(FILE, false));
            ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
            mappingStrategy.setType(ProductBo.class);

            String[] columns = new String[] { "Sku", "Title", "Description", "Price", "Quantity" };
            mappingStrategy.setColumnMapping(columns);

            StatefulBeanToCsvBuilder<ProductBo> builder= new StatefulBeanToCsvBuilder(writer);
            StatefulBeanToCsv beanWriter = builder.withMappingStrategy(mappingStrategy).build();

            beanWriter.write(list);
            writer.flush();
            writer.close();
            return product.get();
        }catch (Exception ex) {
            throw new ProductException(ResponseCode.TECHNICAL_ERROR, "Error during write on file ");
        }
    }
}
