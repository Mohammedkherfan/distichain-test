package com.distichain.test.repository.impl;

import com.distichain.test.bo.ProductBo;
import com.distichain.test.repository.ProductRepository;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private static final String FILE = "./Products.csv";

    @Override
    public Boolean existsBySku(String sku) {
        return null;
    }

    @Override
    public void save(List<ProductBo> products)  {
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(FILE));
            StatefulBeanToCsv<Object> beanToCsv = new StatefulBeanToCsvBuilder<>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            beanToCsv.write(products);
            writer.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ProductBo findBySku(String sku) {
        return null;
    }

    @Override
    public ProductBo update(ProductBo productBo) {
        return null;
    }
}
