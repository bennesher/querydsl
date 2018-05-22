package com.querydsl.sql;

import com.querydsl.core.DefaultQueryMetadata;
import com.querydsl.core.JoinFlag;
import com.querydsl.core.QueryMetadata;
import com.querydsl.core.support.QueryMixin;
import com.querydsl.core.types.*;

import javax.annotation.Nullable;

/**
 *
 */
public class SQLNestedJoinExpressionImpl implements SQLNestedJoinExpression<SQLNestedJoinExpressionImpl> {

    private QueryMetadata metadata = new DefaultQueryMetadata();
    private QueryMixin<SQLNestedJoinExpressionImpl> queryMixin = new QueryMixin<SQLNestedJoinExpressionImpl>( this, metadata);
    private SubQueryExpressionImpl<?> subQueryMixin = new SubQueryExpressionImpl<Object>( Object.class, metadata );

    /**
     * Start a nested join expression chain, without a first table-like
     * expression. For this reason, the first join applied should not
     * have an {@link #on} clause.
     */
    public SQLNestedJoinExpressionImpl() {
    }

    /**
     * Start off a nested chain of joins with the root of the join
     *
     * @param root The root of the join
     */
    public SQLNestedJoinExpressionImpl(EntityPath<?> root) {
        join(root);
    }

    /**
     * Accept the visitor (the SQLSerializer) with the given context
     *
     * @param v       visitor
     * @param context context of visit
     * @return result of visit
     */
    @Nullable
    @Override
    public <R, C> R accept(Visitor<R, C> v, @Nullable C context) {
        if (v instanceof SQLSerializer) {
            SQLSerializer serializer = (SQLSerializer) v;
            serializer.append("(");
            serializer.serializeSources(metadata.getJoins(), true);
            serializer.append(")");
        } else {
            // Need to visit all contained expressions
            subQueryMixin.accept( v, context );
        }
        return null;
    }

    /**
     * Get the java type for this expression
     *
     * @return type of expression
     */
    @Override
    public Class<? extends Void> getType() {
        return Void.TYPE;
    }

    /**
     * Add the given String literal as a join flag to the last added join with the
     * position BEFORE_TARGET
     *
     * @param flag join flag
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl addJoinFlag(String flag) {
        return addJoinFlag(flag, JoinFlag.Position.BEFORE_TARGET);
    }

    /**
     * Add the given String literal as a join flag to the last added join
     *
     * @param flag     join flag
     * @param position position
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl addJoinFlag(String flag, JoinFlag.Position position) {
        return queryMixin.addJoinFlag( new JoinFlag( flag, position));
    }

    /**
     * Adds a full join to the given target
     *
     * @param o full join target
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl fullJoin(EntityPath<?> o) {
        return queryMixin.fullJoin( o);
    }

    /**
     * Adds a full join to the given target
     *
     * @param o     full join target
     * @param alias alias
     * @return the current object
     */
    @Override
    public <E> SQLNestedJoinExpressionImpl fullJoin(EntityPath<E> o, Path<E> alias) {
        return queryMixin.fullJoin( o, alias);
    }

    /**
     * Adds a full join to the given target
     *
     * @param o     full join target
     * @param alias alias
     * @return the current object
     */
    @Override
    public <E> SQLNestedJoinExpressionImpl fullJoin(RelationalFunctionCall<E> o, Path<E> alias) {
        return queryMixin.fullJoin( o, alias);
    }

    /**
     * Adds a full join to the given target
     *
     * @param key    foreign key for join
     * @param entity join target
     * @return the current object
     */
    @Override
    public <E> SQLNestedJoinExpressionImpl fullJoin(ForeignKey<E> key, RelationalPath<E> entity) {
        return queryMixin.fullJoin( entity).on( key.on( entity));
    }

    /**
     * Adds a full join to the given target
     *
     * @param o     subquery
     * @param alias alias
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl fullJoin(SubQueryExpression<?> o, Path<?> alias) {
        return queryMixin.fullJoin( o, alias);
    }

    /**
     * Adds a full join to the given nested join target
     *
     * @param nested The nested join expression
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl fullJoin(SQLNestedJoinExpression<?> nested) {
        return queryMixin.fullJoin( nested);
    }

    /**
     * Adds an inner join to the given target
     *
     * @param o
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl innerJoin(EntityPath<?> o) {
        return queryMixin.innerJoin( o);
    }

    /**
     * Adds an inner join to the given target
     *
     * @param o     inner join target
     * @param alias alias
     * @return the current object
     */
    @Override
    public <E> SQLNestedJoinExpressionImpl innerJoin(EntityPath<E> o, Path<E> alias) {
        return queryMixin.innerJoin( o, alias);
    }

    /**
     * Adds a inner join to the given target
     *
     * @param o     relational function call
     * @param alias alias
     * @return the current object
     */
    @Override
    public <E> SQLNestedJoinExpressionImpl innerJoin(RelationalFunctionCall<E> o, Path<E> alias) {
        return queryMixin.innerJoin( o, alias);
    }

    /**
     * Adds an inner join to the given target
     *
     * @param foreign foreign key to use for join
     * @param entity  join target
     * @return the current object
     */
    @Override
    public <E> SQLNestedJoinExpressionImpl innerJoin(ForeignKey<E> foreign, RelationalPath<E> entity) {
        return queryMixin.innerJoin( entity).on( foreign.on( entity));
    }

    /**
     * Adds an inner join to the given target
     *
     * @param o     subquery
     * @param alias alias
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl innerJoin(SubQueryExpression<?> o, Path<?> alias) {
        return queryMixin.innerJoin( o, alias);
    }

    /**
     * Adds an inner join to the given nested join target
     *
     * @param nested The nested join expression
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl innerJoin(SQLNestedJoinExpression<?> nested) {
        return queryMixin.innerJoin( nested);
    }

    /**
     * Adds a join to the given target
     *
     * @param o join target
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl join(EntityPath<?> o) {
        return queryMixin.join( o);
    }

    /**
     * Adds a join to the given target
     *
     * @param o     join target
     * @param alias alias
     * @return the current object
     */
    @Override
    public <E> SQLNestedJoinExpressionImpl join(EntityPath<E> o, Path<E> alias) {
        return queryMixin.join( o, alias);
    }

    /**
     * Adds a join to the given target
     *
     * @param o     join target
     * @param alias alias
     * @return the current object
     */
    @Override
    public <E> SQLNestedJoinExpressionImpl join(RelationalFunctionCall<E> o, Path<E> alias) {
        return queryMixin.join( o, alias);
    }

    /**
     * Adds a join to the given target
     *
     * @param foreign foreign key to use for join
     * @param entity  join target
     * @return the current object
     */
    @Override
    public <E> SQLNestedJoinExpressionImpl join(ForeignKey<E> foreign, RelationalPath<E> entity) {
        return queryMixin.join( entity).on( foreign.on( entity));
    }

    /**
     * Adds a join to the given target
     *
     * @param o     subquery
     * @param alias alias
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl join(SubQueryExpression<?> o, Path<?> alias) {
        return queryMixin.join( o, alias);
    }

    /**
     * Adds a join to the given nested join target
     *
     * @param nested The nested join expression
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl join(SQLNestedJoinExpression<?> nested) {
        return queryMixin.join( nested);
    }

    /**
     * Adds a left join to the given target
     *
     * @param o join target
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl leftJoin(EntityPath<?> o) {
        return queryMixin.leftJoin( o);
    }

    /**
     * Adds a left join to the given target
     *
     * @param o     left join target
     * @param alias alias
     * @return the current object
     */
    @Override
    public <E> SQLNestedJoinExpressionImpl leftJoin(EntityPath<E> o, Path<E> alias) {
        return queryMixin.leftJoin( o, alias);
    }

    /**
     * Adds a left join to the given target
     *
     * @param o     relational function call
     * @param alias alias
     * @return the current object
     */
    @Override
    public <E> SQLNestedJoinExpressionImpl leftJoin(RelationalFunctionCall<E> o, Path<E> alias) {
        return queryMixin.leftJoin( o, alias);
    }

    /**
     * Adds a left join to the given target
     *
     * @param foreign foreign key to use for join
     * @param entity  join target
     * @return the current object
     */
    @Override
    public <E> SQLNestedJoinExpressionImpl leftJoin(ForeignKey<E> foreign, RelationalPath<E> entity) {
        return queryMixin.leftJoin( entity).on( foreign.on( entity));
    }

    /**
     * Adds a left join to the given target
     *
     * @param o     subquery
     * @param alias alias
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl leftJoin(SubQueryExpression<?> o, Path<?> alias) {
        return queryMixin.leftJoin( o, alias);
    }

    /**
     * Adds a left join to the given nested join target
     *
     * @param nested The nested join expression
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl leftJoin(SQLNestedJoinExpression<?> nested) {
        return queryMixin.leftJoin( nested);
    }

    /**
     * Defines a filter to the last added join
     *
     * @param conditions join conditions
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl on(Predicate... conditions) {
        return queryMixin.on( conditions);
    }

    /**
     * Adds a right join to the given target
     *
     * @param o join target
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl rightJoin(EntityPath<?> o) {
        return queryMixin.rightJoin( o);
    }

    /**
     * Adds a right join to the given target
     *
     * @param o     right join target
     * @param alias alias
     * @return the current object
     */
    @Override
    public <E> SQLNestedJoinExpressionImpl rightJoin(EntityPath<E> o, Path<E> alias) {
        return queryMixin.rightJoin( o, alias);
    }

    /**
     * Adds a full join to the given target
     *
     * @param o     relational function call
     * @param alias alias
     * @return the current object
     */
    @Override
    public <E> SQLNestedJoinExpressionImpl rightJoin(RelationalFunctionCall<E> o, Path<E> alias) {
        return queryMixin.rightJoin( o, alias);
    }

    /**
     * Adds a right join to the given target
     *
     * @param foreign foreign key to use for join
     * @param entity  join target
     * @return the current object
     */
    @Override
    public <E> SQLNestedJoinExpressionImpl rightJoin(ForeignKey<E> foreign, RelationalPath<E> entity) {
        return queryMixin.rightJoin( entity).on( foreign.on( entity));
    }

    /**
     * Adds a right join to the given target
     *
     * @param o     subquery
     * @param alias alias
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl rightJoin(SubQueryExpression<?> o, Path<?> alias) {
        return queryMixin.rightJoin( o, alias);
    }

    /**
     * Adds a right join to the given nested join target
     *
     * @param nested The nested join expression
     * @return the current object
     */
    @Override
    public SQLNestedJoinExpressionImpl rightJoin(SQLNestedJoinExpression<?> nested) {
        return queryMixin.rightJoin( nested);
    }
}
