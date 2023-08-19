package dev.jlkeesh.papertrade.controller;

import dev.jlkeesh.papertrade.service.GenericService;

/**
 * @author : Elmurodov Javohir
 * @since : 16/08/23 / 21:42
 */
public abstract class AbstractController<S extends GenericService> {
    protected final String PATH = "/api";
    protected final S service;

    protected AbstractController(S service) {
        this.service = service;
    }
}
