package com.example.demo.repository;

import com.example.demo.entity.SinhVien;
import jakarta.persistence.Column;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {

    @Query(value = """
       SELECT sv.id AS id,
              sv.ho_ten as ho_ten,
              sv.dia_chi AS dia_chi,
              sv.gioi_tinh as gioi_tinh
       FROM sinh_vien sv
    """,countQuery = """
        SELECT COUNT(*)
       FROM sinh_vien sv
    """
            ,nativeQuery = true)
    Page<SinhVien> phanTrang(Pageable pageable);


}
