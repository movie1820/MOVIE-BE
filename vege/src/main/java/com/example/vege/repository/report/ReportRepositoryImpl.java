package com.example.vege.repository.report;

import com.example.vege.entity.Report;
import com.example.vege.repository.report.ReportRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.vege.entity.QReport.report;

@Repository
@RequiredArgsConstructor
public class ReportRepositoryImpl implements ReportRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Report> findList(Long page) {
        return jpaQueryFactory.selectFrom(report)
                .limit(10)
                .offset(page)
                .orderBy(report.createdAt.desc())
                .fetch();
    }
}
