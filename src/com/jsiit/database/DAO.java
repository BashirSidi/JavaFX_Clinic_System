/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.database;

import java.util.List;

/**
 *
 * @author JSIIT
 */
public interface DAO<T> {
    T get(int t);
    List<T> gets();
    boolean add(T t);
    boolean update(T t);
}
