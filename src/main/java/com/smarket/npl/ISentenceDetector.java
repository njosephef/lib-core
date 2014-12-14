package com.smarket.npl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import opennlp.tools.util.InvalidFormatException;

public interface ISentenceDetector
{
    void detectSentence() throws FileNotFoundException, InvalidFormatException, IOException;
    void detectSentence(String string) throws FileNotFoundException, InvalidFormatException, IOException;
    void detectSentence(File file) throws FileNotFoundException, InvalidFormatException, IOException;
}
