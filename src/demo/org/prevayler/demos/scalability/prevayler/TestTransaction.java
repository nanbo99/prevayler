// Prevayler, The Free-Software Prevalence Layer
// Copyright 2001-2006 by Klaus Wuestefeld
//
// This library is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
// FITNESS FOR A PARTICULAR PURPOSE.
//
// Prevayler is a trademark of Klaus Wuestefeld.
// See the LICENSE file for license details.

package org.prevayler.demos.scalability.prevayler;

import static org.prevayler.Safety.Level.LEVEL_5_DEEP_COPYING;

import org.prevayler.GenericTransaction;
import org.prevayler.PrevalenceContext;
import org.prevayler.Safety;
import org.prevayler.demos.scalability.Record;

import java.io.Serializable;

@Safety(LEVEL_5_DEEP_COPYING) class TestTransaction implements GenericTransaction<TransactionSystem, Void, RuntimeException>, Serializable {

    private static final long serialVersionUID = -2634307328586761351L;

    private final Record recordToInsert;

    private final Record recordToUpdate;

    private final long idToDelete;

    TestTransaction(Record recordToInsert, Record recordToUpdate, long idToDelete) {
        this.recordToInsert = recordToInsert;
        this.recordToUpdate = recordToUpdate;
        this.idToDelete = idToDelete;
    }

    public Void executeOn(TransactionSystem system, @SuppressWarnings("unused") PrevalenceContext prevalenceContext) {
        system.performTransaction(recordToInsert, recordToUpdate, idToDelete);
        return null;
    }

}
