package com.querydsl.sql;

import com.querydsl.core.JoinFlag;
import com.querydsl.core.types.Predicate;

/**
 * The {@code SQLJoinBuilder} extends {@link SQLJoinable} to add the operations
 * needed for qualifying a join, prior to chaining on the next join.
 *
 * @param <Q> The concrete type
 */
public interface SQLJoinBuilder<Q extends SQLJoinBuilder<Q>> extends SQLJoinable<Q> {
    /**
     * Add the given String literal as a join flag to the last added join with the
     * position BEFORE_TARGET
     *
     * @param flag join flag
     * @return the current object
     */
    Q addJoinFlag(String flag);

    /**
     * Add the given String literal as a join flag to the last added join
     *
     * @param flag join flag
     * @param position position
     * @return the current object
     */
    Q addJoinFlag(String flag, JoinFlag.Position position);

    /**
     * Defines a filter to the last added join
     *
     * @param conditions join conditions
     * @return the current object
     */
    Q on(Predicate... conditions);

}
