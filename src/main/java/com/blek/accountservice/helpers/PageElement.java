/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.blek.accountservice.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 *
 * @author blekg
 */
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PageElement<T>{
    private int size;
    private int currentPage;
    private int totalPages;
    private long totalElements;
    private List<T> elements;
}
