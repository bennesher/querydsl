/*
 * Copyright 2015, The Querydsl Team (http://www.querydsl.com/team)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.querydsl.sql;

import static com.querydsl.sql.SQLExpressions.selectFrom;
import static org.junit.Assert.assertEquals;

import com.querydsl.sql.domain.QEmployee;
import org.easymock.EasyMock;
import org.junit.Ignore;
import org.junit.Test;

import com.querydsl.sql.domain.QSurvey;

import java.sql.Connection;

public class JoinUsageTest {

    private final Connection connection = EasyMock.createMock(Connection.class);

    @Test(expected = IllegalStateException.class)
    @Ignore
    public void join_already_declared() {
        QSurvey survey = QSurvey.survey;
        selectFrom(survey).fullJoin(survey);
    }

    @Test
    public void nested_join() {
        QEmployee employee = new QEmployee("EMP");
        QEmployee superior = new QEmployee("SUP");
        QEmployee peer = new QEmployee("PEER");

        // We want one record pairing the employee with each peer - but we still
        // want one record for the employee if there are no peers
        // Yes, there are better ways to write this case, but there are other
        // cases where this is truly useful
        SQLQuery<?> query = new SQLQuery<Void>(connection,SQLTemplates.DEFAULT);
        query.from(employee)
             .leftJoin(
                     peer.innerJoin(peer.superiorIdKey, superior)
            ).on(superior.id.eq(employee.superiorId));
        assertEquals("from EMPLOYEE EMP\n" +
                              "left join (EMPLOYEE PEER\n" +
                              "inner join EMPLOYEE SUP\n" +
                             "on PEER.SUPERIOR_ID = SUP.ID)\n" +
                             "on SUP.ID = EMP.SUPERIOR_ID", query.toString());
    }
}
