package com.distichain.test.repository.impl;

import com.distichain.test.bo.ProductBo;
import com.distichain.test.repository.ProductRepository;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileWriter;
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
            FileWriter writer = new FileWriter(FILE, true);

            StatefulBeanToCsv<ProductBo> statefulBeanToCsv = new StatefulBeanToCsvBuilder<ProductBo>(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
                    .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                    .withOrderedResults(false)
                    .build();
            statefulBeanToCsv.write(products);
            writer.close();
        }catch (Exception ex) {
            System.out.println("Error during write on file ");
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
