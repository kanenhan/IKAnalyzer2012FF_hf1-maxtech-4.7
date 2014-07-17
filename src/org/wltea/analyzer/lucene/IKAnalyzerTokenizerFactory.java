package org.wltea.analyzer.lucene;

import java.io.Reader;
import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeSource.AttributeFactory;

public class IKAnalyzerTokenizerFactory extends TokenizerFactory{

    private boolean useSmart;

    public boolean useSmart() {
        return useSmart;
    }

    public void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }

    public IKAnalyzerTokenizerFactory(Map<String, String> args) {
        super(args);
        assureMatchVersion();
        this.setUseSmart(args.get("useSmart").toString().equals("true"));
    }


    @Override
    public Tokenizer create(AttributeFactory factory, Reader input) {
        Tokenizer _IKTokenizer = new IKTokenizer(input , this.useSmart);
        return _IKTokenizer;
    }

}