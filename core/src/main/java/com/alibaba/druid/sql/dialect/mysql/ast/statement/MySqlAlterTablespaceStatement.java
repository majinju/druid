/*
 * Copyright 1999-2017 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.sql.dialect.mysql.ast.statement;

import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLName;
import com.alibaba.druid.sql.ast.statement.SQLAlterStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitor;

public class MySqlAlterTablespaceStatement extends MySqlStatementImpl implements SQLAlterStatement {
    private SQLName name;

    private SQLExpr addDataFile;
    private SQLExpr dropDataFile;
    private SQLExpr initialSize;
    private boolean wait;
    private SQLExpr engine;

    public void accept0(MySqlASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, name);
            acceptChild(visitor, addDataFile);
            acceptChild(visitor, initialSize);
            acceptChild(visitor, engine);
        }
        visitor.endVisit(this);
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        if (name != null) {
            name.setParent(this);
        }
        this.name = name;
    }

    public SQLExpr getAddDataFile() {
        return addDataFile;
    }

    public void setAddDataFile(SQLExpr addDataFile) {
        if (addDataFile != null) {
            addDataFile.setParent(this);
        }
        this.addDataFile = addDataFile;
    }

    public SQLExpr getDropDataFile() {
        return dropDataFile;
    }

    public void setDropDataFile(SQLExpr dropDataFile) {
        if (dropDataFile != null) {
            dropDataFile.setParent(this);
        }
        this.dropDataFile = dropDataFile;
    }

    public SQLExpr getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(SQLExpr x) {
        if (x != null) {
            x.setParent(this);
        }
        this.initialSize = x;
    }

    public boolean isWait() {
        return wait;
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }

    public SQLExpr getEngine() {
        return engine;
    }

    public void setEngine(SQLExpr engine) {
        if (engine != null) {
            engine.setParent(this);
        }
        this.engine = engine;
    }
}
