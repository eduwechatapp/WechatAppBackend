package com.eduwechat.backend.backend.repository.v2.common;

import com.eduwechat.backend.backend.entity.v2.common.CommonEntityV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AggregationCommonDao extends JpaRepository<CommonEntityV2, Integer> {

    @Query(value = "select erji from :table where yiji = :yiji group by erji order by min(id)", nativeQuery = true)
    List<String> getWhichFromTableAndYiji(@Param("table") String table, @Param("yiji") String yiji);

}
