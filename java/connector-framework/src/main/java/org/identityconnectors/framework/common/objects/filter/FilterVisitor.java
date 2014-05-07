/*
 * ====================
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2014 ForgeRock AS. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License("CDDL") (the "License").  You may not use this file
 * except in compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://opensource.org/licenses/cddl1.php
 * See the License for the specific language governing permissions and limitations
 * under the License.
 *
 * When distributing the Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://opensource.org/licenses/cddl1.php.
 * If applicable, add the following below this CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 * ====================
 */

package org.identityconnectors.framework.common.objects.filter;

import java.util.List;

/**
 * A visitor of {@code Filter}s, in the style of the visitor design
 * pattern.
 * <p>
 * Classes implementing this interface can query filters in a type-safe manner.
 * When a visitor is passed to a filter's accept method, the corresponding visit
 * method most applicable to that filter is invoked.
 *
 * @param <R>
 *            The return type of this visitor's methods. Use
 *            {@link java.lang.Void} for visitors that do not need to return
 *            results.
 * @param <P>
 *            The type of the additional parameter to this visitor's methods.
 *            Use {@link java.lang.Void} for visitors that do not need an
 *            additional parameter.
 * @since 1.4
 */
public interface FilterVisitor<R, P> {

    /**
     * Visits an {@code and} filter.
     * <p>
     * <b>Implementation note</b>: for the purposes of matching, an empty
     * sub-filters should always evaluate to {@code true}.
     *
     * @param p
     *            A visitor specified parameter.
     * @param left
     *            The left sub-filter.
     * @param right
     *            The right sub-filter.
     * @return Returns a visitor specified result.
     */
    R visitAndFilter(P p, Filter left, Filter right);

    /**
     * Visits a {@code contains} filter.
     *
     * @param p
     *            A visitor specified parameter.
     * @param name
     *            A name of the attribute within ConnectorObject to be compared.
     * @param valueAssertion
     *            The value assertion.
     * @return Returns a visitor specified result.
     */
    R visitContainsFilter(P p, String name, String valueAssertion);

    /**
     * Visits a {@code containsAll} filter.
     *
     * @param p
     *            A visitor specified parameter.
     * @param name
     *            A name of the attribute within ConnectorObject to be compared.
     * @param valueAssertion
     *            The value assertion.
     * @return Returns a visitor specified result.
     */
    R visitContainsAllFilter(P p, String name, List<Object> valueAssertion);

    /**
     * Visits a {@code equality} filter.
     *
     * @param p
     *            A visitor specified parameter.
     * @param name
     *            A name of the attribute within ConnectorObject to be compared.
     * @param valueAssertion
     *            The value assertion.
     * @return Returns a visitor specified result.
     */
    R visitEqualsFilter(P p, String name, List<Object> valueAssertion);


    /**
     * Visits a {@code comparison} filter.
     *
     * @param p
     *            A visitor specified parameter.
     * @param name
     *            A name of the attribute within ConnectorObject to be compared.
     * @param filter
     *            The original filter.
     * @param valueAssertion
     *            The value assertion.
     * @return Returns a visitor specified result.
     */
    R visitExtendedFilter(P p, String name, Filter filter, List<Object> valueAssertion);

    /**
     * Visits a {@code greater than} filter.
     *
     * @param p
     *            A visitor specified parameter.
     * @param name
     *            A name of the attribute within ConnectorObject to be compared.
     * @param valueAssertion
     *            The value assertion.
     * @return Returns a visitor specified result.
     */
    R visitGreaterThanFilter(P p, String name, Object valueAssertion);

    /**
     * Visits a {@code greater than or equal to} filter.
     *
     * @param p
     *            A visitor specified parameter.
     * @param name
     *            A name of the attribute within ConnectorObject to be compared.
     * @param valueAssertion
     *            The value assertion.
     * @return Returns a visitor specified result.
     */
    R visitGreaterThanOrEqualToFilter(P p, String name, Object valueAssertion);

    /**
     * Visits a {@code less than} filter.
     *
     * @param p
     *            A visitor specified parameter.
     * @param name
     *            A name of the attribute within ConnectorObject to be compared.
     * @param valueAssertion
     *            The value assertion.
     * @return Returns a visitor specified result.
     */
    R visitLessThanFilter(P p, String name, Object valueAssertion);

    /**
     * Visits a {@code less than or equal to} filter.
     *
     * @param p
     *            A visitor specified parameter.
     * @param name
     *            A name of the attribute within ConnectorObject to be compared.
     * @param valueAssertion
     *            The value assertion.
     * @return Returns a visitor specified result.
     */
    R visitLessThanOrEqualToFilter(P p, String name, Object valueAssertion);

    /**
     * Visits a {@code not} filter.
     *
     * @param p
     *            A visitor specified parameter.
     * @param subFilter
     *            The sub-filter.
     * @return Returns a visitor specified result.
     */
    R visitNotFilter(P p, Filter subFilter);

    /**
     * Visits an {@code or} filter.
     * <p>
     * <b>Implementation note</b>: for the purposes of matching, an empty
     * sub-filters should always evaluate to {@code false}.
     *
     * @param p
     *            A visitor specified parameter.
     * @param left
     *            The left sub-filter.
     * @param right
     *            The right sub-filter.
     * @return Returns a visitor specified result.
     */
    R visitOrFilter(P p, Filter left, Filter right);

    /**
     * Visits a {@code starts with} filter.
     *
     * @param p
     *            A visitor specified parameter.
     * @param name
     *            A pointer to the attribute within ConnectorObject to be
     *            compared.
     * @param valueAssertion
     *            The value assertion.
     * @return Returns a visitor specified result.
     */
    R visitStartsWithFilter(P p, String name, String valueAssertion);

    /**
     * Visits a {@code ends with} filter.
     *
     * @param p
     *            A visitor specified parameter.
     * @param name
     *            A pointer to the attribute within ConnectorObject to be
     *            compared.
     * @param valueAssertion
     *            The value assertion.
     * @return Returns a visitor specified result.
     */
    R visitEndsWithFilter(P p, String name, String valueAssertion);

}
