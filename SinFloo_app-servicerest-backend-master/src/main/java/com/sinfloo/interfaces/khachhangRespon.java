package com.sinfloo.interfaces;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.sinfloo.modelo.khachhang;

import java.util.List;

@Repository
public interface khachhangRespon extends CrudRepository<khachhang, Integer> {
//	List<khachhang> findByTaiKhoan(String taiKhoan);
//	 khachhang getByUsername(String username);
}
