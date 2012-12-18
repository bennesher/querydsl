package com.mysema.query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.mysema.query.collections.Cat;
import com.mysema.query.collections.CollQueryFactory;
import com.mysema.query.collections.QCat;
import com.mysema.testutil.Benchmark;
import com.mysema.testutil.Runner;

@Ignore
public class QueryPerformanceTest {
    
    private static final int size = 1000;
    
    private static List<Cat> cats = new ArrayList<Cat>(size);
    
    @BeforeClass
    public static void setUpClass() throws SQLException, ClassNotFoundException {
        for (int i = 0; i < size; i++) {
            cats.add(new Cat(String.valueOf(i), i));
        }
    }
    
    @Test
    public void ById() throws Exception {
        Runner.run("by id", new Benchmark() {
            @Override
            public void run(int times) throws Exception {
                for (int i = 0; i < times; i++) {
                    QCat cat = QCat.cat;
                    CollQueryFactory.from(cat, cats).where(cat.id.eq(i % size)).list(cat);
                }                
            }            
        });                      
    }
        

}
