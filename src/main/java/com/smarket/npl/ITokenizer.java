package com.smarket.npl;

import java.io.FileNotFoundException;
import java.io.IOException;

import opennlp.tools.util.InvalidFormatException;

public interface ITokenizer
{
    void tokenize() throws FileNotFoundException, InvalidFormatException, IOException;
    void tokenize(String str) throws FileNotFoundException, InvalidFormatException, IOException;
}
