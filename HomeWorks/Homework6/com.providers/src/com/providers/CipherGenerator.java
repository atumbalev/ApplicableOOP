package com.providers;

import com.services.Cipherable;

public class CipherGenerator {
    public static Result countDistinct(Cipherable cipher, int seed) {
        char[] result = cipher.getSecretChars(seed);

        int unique = 0;

        // O(N^2) time complexity
        // Would insert into a HashSet and count the values for a quick O(N) time complexity
        // But that probably would not be accepted
        for (int i = 0; i < result.length; i++)
        {
            int j = 0;
            for (j = 0; j < i; j++)
                if (result[i] == result[j])
                    break;

            if (i == j)
                unique++;
        }

        return new Result(result, unique);
    }

    public static void main(String[] args) {
        System.out.println(countDistinct(new Wrapper(50).makeFixedSelection(), 15));
    }
}
