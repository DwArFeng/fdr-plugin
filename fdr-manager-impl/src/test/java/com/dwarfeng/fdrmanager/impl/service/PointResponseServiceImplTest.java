package com.dwarfeng.fdrmanager.impl.service;

import com.dwarfeng.fdr.stack.bean.entity.Point;
import com.dwarfeng.fdrmanager.stack.service.PointResponseService;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class PointResponseServiceImplTest {

    private List<Point> points;

    @Autowired
    private PointResponseService service;

    @Before
    public void setUp() {
        points = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Point point = new Point(
                    null,
                    "point-" + (i + 1),
                    "test-point",
                    true,
                    true
            );
            points.add(point);
        }
    }

    @After
    public void tearDown() {
        points.clear();
    }

    @Test
    public void test() throws ServiceException {
        try {
            for (Point point : points) {
                point.setKey(service.insert(point));
                service.update(point);
            }
        } finally {
            for (Point point : points) {
                service.delete(point.getKey());
            }
        }
    }
}