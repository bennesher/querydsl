package com.querydsl.sql;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.SubQueryExpression;

/**
 * A {@code SQLJoinable} class supports the standard SQL join operations,
 * allowing them to be mixed-in to all the places that joins can be chained.
 * This interface is primarily a base for {@link SQLCommonQuery}, but also
 * used for {@link RelationalPath} and {@link SQLNestedJoinExpression} in
 * order to support nested joins. This interface does not have a corresponding
 * abstract implementation because its implementors already have abstract
 * bases.
 *
 * @author tiwe, bennesher
 *
 * @param <Q> concrete type
 */
public interface SQLJoinable<Q extends SQLJoinable<Q>> {
    /**
     * Adds a full join to the given target
     *
     * @param o full join target
     * @return the current object
     */
    Q fullJoin(EntityPath<?> o);

    /**
     * Adds a full join to the given target
     *
     * @param <E>
     * @param o full join target
     * @param alias alias
     * @return the current object
     */
    <E> Q fullJoin(EntityPath<E> o, Path<E> alias);

    /**
     * Adds a full join to the given target
     *
     * @param <E>
     * @param o full join target
     * @param alias alias
     * @return the current object
     */
    <E> Q fullJoin(RelationalFunctionCall<E> o, Path<E> alias);

    /**
     * Adds a full join to the given target
     *
     * @param <E>
     * @param key foreign key for join
     * @param entity join target
     * @return the current object
     */
    <E> Q fullJoin(ForeignKey<E> key, RelationalPath<E> entity);

    /**
     * Adds a full join to the given target
     *
     * @param o subquery
     * @param alias alias
     * @return the current object
     */
    Q fullJoin(SubQueryExpression<?> o, Path<?> alias);

    /**
     * Adds a full join to the given nested join target
     *
     * @param nested The nested join expression
     * @return the current object
     */
    Q fullJoin(SQLNestedJoinExpression<?> nested);

    /**
     * Adds an inner join to the given target
     *
     * @param o
     * @return the current object
     */
    Q innerJoin(EntityPath<?> o);

    /**
     * Adds an inner join to the given target
     *
     * @param <E>
     * @param o inner join target
     * @param alias alias
     * @return the current object
     */
    <E> Q innerJoin(EntityPath<E> o, Path<E> alias);

    /**
     * Adds a inner join to the given target
     *
     * @param <E>
     * @param o relational function call
     * @param alias alias
     * @return the current object
     */
    <E> Q innerJoin(RelationalFunctionCall<E> o, Path<E> alias);

    /**
     * Adds an inner join to the given target
     *
     * @param <E>
     * @param foreign foreign key to use for join
     * @param entity join target
     * @return the current object
     */
    <E> Q innerJoin(ForeignKey<E> foreign, RelationalPath<E> entity);

    /**
     * Adds an inner join to the given target
     *
     * @param o subquery
     * @param alias alias
     * @return the current object
     */
    Q innerJoin(SubQueryExpression<?> o, Path<?> alias);

    /**
     * Adds an inner join to the given nested join target
     *
     * @param nested The nested join expression
     * @return the current object
     */
    Q innerJoin(SQLNestedJoinExpression<?> nested);

    /**
     * Adds a join to the given target
     *
     * @param o join target
     * @return the current object
     */
    Q join(EntityPath<?> o);

    /**
     * Adds a join to the given target
     *
     * @param <E>
     * @param o join target
     * @param alias alias
     * @return the current object
     */
    <E> Q join(EntityPath<E> o, Path<E> alias);

    /**
     * Adds a join to the given target
     *
     * @param <E>
     * @param o join target
     * @param alias alias
     * @return the current object
     */
    <E> Q join(RelationalFunctionCall<E> o, Path<E> alias);

    /**
     * Adds a join to the given target
     *
     * @param <E>
     * @param foreign foreign key to use for join
     * @param entity join target
     * @return the current object
     */
    <E> Q join(ForeignKey<E> foreign, RelationalPath<E> entity);

    /**
     * Adds a join to the given target
     *
     * @param o subquery
     * @param alias alias
     * @return the current object
     */
    Q join(SubQueryExpression<?> o, Path<?> alias);

    /**
     * Adds a join to the given nested join target
     *
     * @param nested The nested join expression
     * @return the current object
     */
    Q join(SQLNestedJoinExpression<?> nested);

    /**
     * Adds a left join to the given target
     *
     * @param o join target
     * @return the current object
     */
    Q leftJoin(EntityPath<?> o);

    /**
     * Adds a left join to the given target
     *
     * @param <E>
     * @param o left join target
     * @param alias alias
     * @return the current object
     */
    <E> Q leftJoin(EntityPath<E> o, Path<E> alias);

    /**
     * Adds a left join to the given target
     *
     * @param <E>
     * @param o relational function call
     * @param alias alias
     * @return the current object
     */
    <E> Q leftJoin(RelationalFunctionCall<E> o, Path<E> alias);

    /**
     * Adds a left join to the given target
     *
     * @param <E>
     * @param foreign foreign key to use for join
     * @param entity join target
     * @return the current object
     */
    <E> Q leftJoin(ForeignKey<E> foreign, RelationalPath<E> entity);

    /**
     * Adds a left join to the given target
     *
     * @param o subquery
     * @param alias alias
     * @return the current object
     */
    Q leftJoin(SubQueryExpression<?> o, Path<?> alias);

    /**
     * Adds a left join to the given nested join target
     *
     * @param nested The nested join expression
     * @return the current object
     */
    Q leftJoin(SQLNestedJoinExpression<?> nested);

    /**
     * Adds a right join to the given target
     *
     * @param o join target
     * @return the current object
     */
    Q rightJoin(EntityPath<?> o);

    /**
     * Adds a right join to the given target
     *
     * @param <E>
     * @param o right join target
     * @param alias alias
     * @return the current object
     */
    <E> Q rightJoin(EntityPath<E> o, Path<E> alias);

    /**
     * Adds a full join to the given target
     *
     * @param <E>
     * @param o relational function call
     * @param alias alias
     * @return the current object
     */
    <E> Q rightJoin(RelationalFunctionCall<E> o, Path<E> alias);

    /**
     * Adds a right join to the given target
     *
     * @param <E>
     * @param foreign foreign key to use for join
     * @param entity join target
     * @return the current object
     */
    <E> Q rightJoin(ForeignKey<E> foreign, RelationalPath<E> entity);

    /**
     * Adds a right join to the given target
     *
     * @param o subquery
     * @param alias alias
     * @return the current object
     */
    Q rightJoin(SubQueryExpression<?> o, Path<?> alias);

    /**
     * Adds a right join to the given nested join target
     *
     * @param nested The nested join expression
     * @return the current object
     */
    Q rightJoin(SQLNestedJoinExpression<?> nested);
}
