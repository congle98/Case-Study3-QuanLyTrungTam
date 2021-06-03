package com.app.service;

import com.app.models.Address;
import com.app.models.Blog;
import com.app.service.IService;

import java.util.List;

public class BlogService implements IService<Blog> {
    @Override
    public List<Blog> findAll() {
        return null;
    }

    @Override
    public Blog findById(int id) {
        return null;
    }

    @Override
    public void save(Blog p) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(int id, Blog blog) {

    }
}
