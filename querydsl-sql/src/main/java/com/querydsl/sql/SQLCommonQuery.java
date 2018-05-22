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

import com.querydsl.core.Query;
import com.querydsl.core.QueryFlag.Position;
import com.querydsl.core.types.*;

/**
 * {@code SQLCommonQuery} is a common interface for SQLQuery and SQLSubQuery
 *
 * @author tiwe
 *
 * @param <Q> concrete type
 */
public interface SQLCommonQuery<Q extends SQLCommonQuery<Q>> extends Query<Q>, SQLJoinBuilder<Q> {

    /**
     * Add the given Expression as a query flag
     *
     * @param position position
     * @param flag query flag
     * @return the current object
     */
    Q addFlag(Position position, Expression<?> flag);

    /**
     * Add the given String literal as query flag
     *
     * @param position position
     * @param flag query flag
     * @return the current object
     */
    Q addFlag(Position position, String flag);

    /**
     * Add the given prefix and expression as a general query flag
     *
     * @param position position of the flag
     * @param prefix prefix for the flag
     * @param expr expression of the flag
     * @return the current object
     */
    Q addFlag(Position position, String prefix, Expression<?> expr);

    /**
     * Defines the sources of the query
     *
     * @param o from
     * @return the current object
     */
    Q from(Expression<?>... o);

    /**
     * Adds a sub query source
     *
     * @param subQuery sub query
     * @param alias alias
     * @return the current object
     */
    Q from(SubQueryExpression<?> subQuery, Path<?> alias);

    /**
     * Adds a common table expression
     *
     * <p>Usage</p>
     * <pre>
     * query.with(alias, subQuery)
     *      .from(...)
     * </pre>
     *
     * @param alias alias for query
     * @param o subquery
     * @return the current object
     */
    Q with(Path<?> alias, SubQueryExpression<?> o);

    /**
     * Adds a common table expression
     *
     * <p>Usage</p>
     * <pre>
     * query.with(alias, subQuery)
     *      .from(...)
     * </pre>
     *
     * @param alias alias for query
     * @param query subquery
     * @return the current object
     */
    Q with(Path<?> alias, Expression<?> query);

    /**
     * Adds a common table expression
     *
     * <p>Usage</p>
     * <pre>
     * query.with(alias, columns...).as(subQuery)
     *      .from(...)
     * </pre>
     *
     * @param alias alias for query
     * @param columns columns to use
     * @return the current object
     */
    WithBuilder<Q> with(Path<?> alias, Path<?>... columns);

    /**
     * Adds a common table expression
     *
     * <p>Usage</p>
     * <pre>
     * query.withRecursive(alias, subQuery)
     *      .from(...)
     * </pre>
     *
     * @param alias alias for query
     * @param o subquery
     * @return the current object
     */
    Q withRecursive(Path<?> alias, SubQueryExpression<?> o);

    /**
     * Adds a common table expression
     *
     * <p>Usage</p>
     * <pre>
     * query.withRecursive(alias, subQuery)
     *      .from(...)
     * </pre>
     *
     * @param alias alias for query
     * @param query subquery
     * @return the current object
     */
    Q withRecursive(Path<?> alias, Expression<?> query);

    /**
     * Adds a common table expression
     *
     * <p>Usage</p>
     * <pre>
     * query.withRecursive(alias, columns...).as(subQuery)
     *      .from(...)
     * </pre>
     *
     * @param alias alias for query
     * @param columns columns to use
     * @return builder for with part
     */
    WithBuilder<Q> withRecursive(Path<?> alias, Path<?>... columns);
}
