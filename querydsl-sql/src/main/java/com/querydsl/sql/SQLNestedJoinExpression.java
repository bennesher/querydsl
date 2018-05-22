package com.querydsl.sql;

import com.querydsl.core.types.Expression;
import com.querydsl.core.JoinExpression;

/**
 * An ANSI nested join expression, to be used as part of another join.
 * Note that while the {@link JoinExpression} needs an {@link Expression}
 * for the target, a {@code SQLNestedJoinExpression} isn't really a valid
 * expression for any other purposes, so it is an {@code Expression<Void>}.
 *
 * @author bennesher
 *
 * @param <Q> The concrete implementation type - used for chaining
 */
public interface SQLNestedJoinExpression<Q extends SQLNestedJoinExpression<Q>> extends Expression<Void>, SQLJoinBuilder<Q> {
}
