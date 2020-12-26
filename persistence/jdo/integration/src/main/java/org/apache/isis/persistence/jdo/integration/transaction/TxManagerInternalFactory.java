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
package org.apache.isis.persistence.jdo.integration.transaction;

import org.apache.isis.applib.services.xactn.TransactionalProcessor;
import org.apache.isis.core.interaction.session.InteractionTracker;
import org.apache.isis.core.metamodel.context.MetaModelContext;
import org.apache.isis.persistence.jdo.provider.persistence.HasPersistenceManager;

import lombok.val;

public class TxManagerInternalFactory {

    public static TransactionalProcessor newTransactionalProcessor(
            MetaModelContext mmc,
            HasPersistenceManager pmProvider) {
        
        val txMan = new _TxProcessor(mmc, pmProvider);
        
        val isisInteractionTracker = mmc.getServiceRegistry()
                .lookupServiceElseFail(InteractionTracker.class);
        
        isisInteractionTracker.currentInteractionSession()
                .map(interaction->interaction.putAttribute(_TxProcessor.class, txMan));
        
        return txMan;
        
    }

}
