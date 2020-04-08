/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.isis.viewer.common.model.action;

import org.apache.isis.core.metamodel.spec.feature.ObjectAction;
import org.apache.isis.viewer.common.model.link.ActionLinkFactory;
import org.apache.isis.viewer.common.model.object.ObjectUiModel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @since 2.0.0
 * @param <T> - link component type, native to the viewer
 */
@Getter @RequiredArgsConstructor
public class ActionUiModel<T> {

    private final ActionLinkFactory<T> actionLinkFactory;
    private final String actionName;
    private final ObjectAction objectAction;
    private final ObjectUiModel actionHolder;

    @Override
    public String toString() {
        return actionName + " ~ " + objectAction.getIdentifier().toFullIdentityString();
    }
}