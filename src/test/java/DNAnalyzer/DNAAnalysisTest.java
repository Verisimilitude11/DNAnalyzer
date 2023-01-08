/*
 * Copyright © 2023 DNAnalyzer. Some rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * You are entirely responsible for the use of this application, including any and all activities that occur.
 * While DNAnalyzer strives to fix all major bugs that may be either reported by a user or discovered while debugging,
 * they will not be held liable for any loss that the user may incur as a result of using this application, under any circumstances.
 *
 * For further inquiries, please reach out to contact@dnanalyzer.live
 */

package DNAnalyzer;

import DNAnalyzer.core.DNAAnalysis;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;

import static DNAnalyzer.utils.core.Utils.readFile;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DNAAnalysisTest {

    @Test
    void testCountBasePairs() {
        Path projectPath = Path.of("");
        Path brcaPath = projectPath.resolve("assets/dna/real/brca1.fa");

        String brcaDnaString = readFile(brcaPath.toFile());
        //a = 3790, t = 2837, g = 1903, c = 1804
        long[] expected = {3790, 2837, 1903, 1804};
        long[] actual = DNAAnalysis.countBasePairs(brcaDnaString);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testCountBasePairsWithEmptyString() {
        String testEmptyString = "";
        long[] expected = {0, 0, 0, 0};
        long[] actual = DNAAnalysis.countBasePairs(testEmptyString);
        assertArrayEquals(expected, actual);

    }

    @Test
    void testCountBasePairsWithNullString() {
        long[] expected = {0, 0, 0, 0};
        long[] actual = DNAAnalysis.countBasePairs(null);
        assertArrayEquals(expected, actual);
    }
}
