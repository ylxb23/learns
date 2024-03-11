package com.zero.learns.collection;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * com.zero.learns.collection.ToolCheck
 *
 * @author ylxb2
 * @since 2024/1/25 11:29
 */
public class ToolCheck {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);

        System.out.println(CollectionUtils.isEmpty(list));
        System.out.println(IteratorUtils.find(list.iterator(), item -> item != null) == null);
    }
}
