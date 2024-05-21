package com.alibaba.druid.sql.dialect.clickhouse.parser;

import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.parser.Keywords;
import com.alibaba.druid.sql.parser.Lexer;
import com.alibaba.druid.sql.parser.SQLParserFeature;
import com.alibaba.druid.sql.parser.Token;

import java.util.HashMap;
import java.util.Map;

public class ClickhouseLexer extends Lexer {
    public static final Keywords DEFAULT_KEYWORDS;

    static {
        Map<String, Token> map = new HashMap<String, Token>();

        map.putAll(Keywords.DEFAULT_KEYWORDS.getKeywords());

        map.put("IF", Token.IF);
        map.put("OF", Token.OF);
        map.put("CONCAT", Token.CONCAT);
        map.put("CONTINUE", Token.CONTINUE);
        map.put("MERGE", Token.MERGE);
        map.put("USING", Token.USING);

        map.put("ROW", Token.ROW);
        map.put("LIMIT", Token.LIMIT);
        map.put("SHOW", Token.SHOW);
        map.put("ALL", Token.ALL);
        map.put("GLOBAL", Token.GLOBAL);
        map.put("PARTITION", Token.PARTITION);

        DEFAULT_KEYWORDS = new Keywords(map);
    }

    public ClickhouseLexer(String input) {
        super(input);
        dbType = DbType.clickhouse;
        super.keywords = DEFAULT_KEYWORDS;
    }

    public ClickhouseLexer(String input, SQLParserFeature... features) {
        super(input);
        super.keywords = DEFAULT_KEYWORDS;
        for (SQLParserFeature feature : features) {
            config(feature, true);
        }
    }
}
