package com.bcit.comp1451.assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import junit.framework.Assert;

public class JavadocTest implements FilenameFilter {
    private static final String NEWLINE_CHAR = System.getProperties().getProperty("line.separator");

    public JavadocTest() {
    }

    public boolean accept(File folder, String name) {
        return name.endsWith(".java");
    }

    private Stack<String> scanIntoStack(Scanner s, String pattern) {
        Stack<String> result = new Stack();
        Matcher m = Pattern.compile(pattern, 32).matcher(s.next());

        while(m.find()) {
            result.push(m.group().replaceAll(NEWLINE_CHAR, " ").replaceAll("\\s+", " ").trim());
        }

        return result;
    }

    @Test
    public void evaluateFilesInThisFolder() {
        String DEFAULT_CLASS_HEADER = "Write a description of class %s here.";
        String DEFAULT_CLASS_HEADER_PENALTY = "-1: The class header for '%s' has been left as the BlueJ-generated default." + NEWLINE_CHAR;
        String NO_CLASS_HEADER_PENALTY = "-1: The class header for '%s' is missing." + NEWLINE_CHAR;
        String UNDOCUMENTED_PARAM_PENALTY = "-1: Incorrect javadoc for parameter '%1s', before %2s.%3s()." + NEWLINE_CHAR;
        String UNDOCUMENTED_RETURN_PENALTY = "-1: %1s.%2s() has an undocumented return value." + NEWLINE_CHAR;
        String failReport = "";
        File[] var7 = (new File(".")).listFiles(this);
        int var8 = var7.length;

        label119:
        for(int var9 = 0; var9 < var8; ++var9) {
            File f = var7[var9];

            try {
                Scanner reader = new Scanner(f, "ISO-8859-1");
                reader.useDelimiter("\\{\\s?[\n\r]+");
                Stack<String> text = this.scanIntoStack(reader, "(?<= \\* )[\\w\\s]+|(?<=class )\\w+|(?<=interface )\\w+|(?<=enum )\\w+");
                if (0 == text.size()) {
                    Assert.fail(String.format("-1: You did not declare a class or interface in %s.", f.getName()));
                }

                String testedClassName = (String)text.pop();
                Class<?> testedModule = Class.forName(testedClassName);
                if (text.isEmpty()) {
                    failReport = failReport + String.format(NO_CLASS_HEADER_PENALTY, testedClassName);
                } else if (String.format("Write a description of class %s here.", testedClassName).equals(text.get(0))) {
                    failReport = failReport + String.format(DEFAULT_CLASS_HEADER_PENALTY, testedClassName);
                }

                HashSet<String> validMethodNames = new HashSet();
                validMethodNames.add(testedClassName);
                Method[] var16 = testedModule.getMethods();
                int var17 = var16.length;

                for(int var18 = 0; var18 < var17; ++var18) {
                    Method method = var16[var18];
                    validMethodNames.add(method.getName());
                }

                while(true) {
                    while(true) {
                        String methodName;
                        boolean hasReturnValue;
                        do {
                            String[] params;
                            int symbolIndex;
                            do {
                                do {
                                    do {
                                        if (!reader.hasNext()) {
                                            continue label119;
                                        }

                                        text = this.scanIntoStack(reader, "((?<=\\*)\\s+@(param|return)\\s+\\S+)|((public|private|protected)[\\s0-z]* \\w+\\([^\\)]*\\))");
                                    } while(0 == text.size());

                                    methodName = (String)text.pop();
                                    params = methodName.split("\\(\\s?");
                                    hasReturnValue = true;
                                    symbolIndex = params.length - 2;
                                } while(0 > symbolIndex);

                                methodName = params[symbolIndex];
                                if (methodName.contains(" void ")) {
                                    hasReturnValue = false;
                                }

                                methodName = methodName.substring(methodName.lastIndexOf(" ") + 1);
                                if (methodName.equals(testedClassName)) {
                                    hasReturnValue = false;
                                }
                            } while(!validMethodNames.contains(methodName));

                            ++symbolIndex;
                            params = params[symbolIndex].split("( ?(,|^) ?[^\\s\\<]+(\\<.+\\>)? )|\\)");
                            boolean skipFirst = true;
                            String[] var20 = params;
                            int var21 = params.length;

                            label101:
                            for(int var22 = 0; var22 < var21; ++var22) {
                                String param = var20[var22];
                                if (skipFirst) {
                                    skipFirst = false;
                                } else {
                                    param = param.trim();
                                    Iterator i = text.iterator();

                                    do {
                                        if (!i.hasNext()) {
                                            failReport = failReport + String.format(UNDOCUMENTED_PARAM_PENALTY, param, testedClassName, methodName);
                                            continue label101;
                                        }
                                    } while(!((String)i.next()).startsWith("@param " + param));

                                    i.remove();
                                }
                            }
                        } while(!hasReturnValue);

                        if (1 == text.size() && ((String)text.get(0)).startsWith("@return ")) {
                            text.pop();
                        } else {
                            failReport = failReport + String.format(UNDOCUMENTED_RETURN_PENALTY, testedClassName, methodName);
                        }
                    }
                }
            } catch (FileNotFoundException var25) {
            } catch (ClassNotFoundException var26) {
                failReport = failReport + String.format("The tester is unable to assess %s.\n> This is OK is it's an interface or abstract class.\n> This is BAD if it's a class file.\n", f.getName());
            }
        }

        if (!"".equals(failReport)) {
            Assert.fail(failReport + "\nSome of your javadoc is incomplete, according to coding standards.\n\n> Every public method should be preceded by a /**multi-line comment block*/.\n\n> In the comment block, describe every parameter with a separate line of this format:\n       @param nameOfParameter      description of the parameter\n  Example:\n       @param message              text that will be displayed to the user;\n                                   must be at least 3 characters long\n\n> If the method returns a value, include exactly one line of this format:\n       @return                     description of the value returned\n  Example:\n       @return                     number of NobelPrizeWinners for the specified year\n");
        }

    }
}

