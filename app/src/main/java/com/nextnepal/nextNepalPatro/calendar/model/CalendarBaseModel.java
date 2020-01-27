package com.nextnepal.nextNepalPatro.calendar.model;

import android.util.SparseArray;

class CalendarBaseModel {

    SparseArray<int[]> daysInMonthMap;

    void getDaysInMonthMap() {
//        if (daysInMonthMap != null) return daysInMonthMap;
        daysInMonthMap = new SparseArray<>();
        /*
         The 0s at index 0 are dummy values so as to make the int array of
         days in months seems more intuitive that index 1 refers to first
         month "Baisakh", index 2 refers to second month "Jesth" and so on.
         */

        // based on https://github.com/bahadurbaniya/Date-Converter-Bikram-Sambat-to-English-Date/blob/master/src/main/java/np/com/converter/date/nepali/Lookup.java

        daysInMonthMap.put(1970, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(1971, new int[]{0, 31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(1972, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(1973, new int[]{0, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        daysInMonthMap.put(1974, new int[]{0, 30, 32, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(1975, new int[]{0, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(1976, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(1977, new int[]{0, 30, 32, 31, 32, 31, 31, 29, 30, 29, 30, 29, 31});
        daysInMonthMap.put(1978, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(1979, new int[]{0, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});

        daysInMonthMap.put(1980, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(1981, new int[]{0, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30});
        daysInMonthMap.put(1982, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(1983, new int[]{0, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(1984, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(1985, new int[]{0, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30});
        daysInMonthMap.put(1986, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(1987, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(1988, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(1989, new int[]{0, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});

        daysInMonthMap.put(1990, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(1991, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30});
        daysInMonthMap.put(1992, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        daysInMonthMap.put(1993, new int[]{0, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(1994, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(1995, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30});
        daysInMonthMap.put(1996, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        daysInMonthMap.put(1997, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(1998, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(1999, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});


        //old
        daysInMonthMap.put(2000, new int[]{0, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        daysInMonthMap.put(2001, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2002, new int[]{0, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2003, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(2004, new int[]{0, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        daysInMonthMap.put(2005, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2006, new int[]{0, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2007, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(2008, new int[]{0, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31});
        daysInMonthMap.put(2009, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2010, new int[]{0, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2011, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(2012, new int[]{0, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30});
        daysInMonthMap.put(2013, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2014, new int[]{0, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2015, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(2016, new int[]{0, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30});
        daysInMonthMap.put(2017, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2018, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2019, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        daysInMonthMap.put(2020, new int[]{0, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2021, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2022, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30});
        daysInMonthMap.put(2023, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        daysInMonthMap.put(2024, new int[]{0, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2025, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2026, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(2027, new int[]{0, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        daysInMonthMap.put(2028, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2029, new int[]{0, 31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2030, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(2031, new int[]{0, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        daysInMonthMap.put(2032, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2033, new int[]{0, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2034, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(2035, new int[]{0, 30, 32, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31});
        daysInMonthMap.put(2036, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2037, new int[]{0, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2038, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(2039, new int[]{0, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30});
        daysInMonthMap.put(2040, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2041, new int[]{0, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2042, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(2043, new int[]{0, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30});
        daysInMonthMap.put(2044, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2045, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2046, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(2047, new int[]{0, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2048, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2049, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30});
        daysInMonthMap.put(2050, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        daysInMonthMap.put(2051, new int[]{0, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2052, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2053, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30});
        daysInMonthMap.put(2054, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        daysInMonthMap.put(2055, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2056, new int[]{0, 31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2057, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(2058, new int[]{0, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        daysInMonthMap.put(2059, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2060, new int[]{0, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2061, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(2062, new int[]{0, 30, 32, 31, 32, 31, 31, 29, 30, 29, 30, 29, 31});
        daysInMonthMap.put(2063, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2064, new int[]{0, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2065, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(2066, new int[]{0, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31});
        daysInMonthMap.put(2067, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2068, new int[]{0, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2069, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(2070, new int[]{0, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30});
        daysInMonthMap.put(2071, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2072, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2073, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        daysInMonthMap.put(2074, new int[]{0, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2075, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2076, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30});
        daysInMonthMap.put(2077, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        daysInMonthMap.put(2078, new int[]{0, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2079, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        daysInMonthMap.put(2080, new int[]{0, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30});
        daysInMonthMap.put(2081, new int[]{0, 31, 31, 32, 32, 31, 30, 30, 30, 29, 30, 30, 30});
        daysInMonthMap.put(2082, new int[]{0, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30});
        daysInMonthMap.put(2083, new int[]{0, 31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30});
        daysInMonthMap.put(2084, new int[]{0, 31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30});
        daysInMonthMap.put(2085, new int[]{0, 31, 32, 31, 32, 30, 31, 30, 30, 29, 30, 30, 30});
        daysInMonthMap.put(2086, new int[]{0, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30});
        daysInMonthMap.put(2087, new int[]{0, 31, 31, 32, 31, 31, 31, 30, 30, 29, 30, 30, 30});
        daysInMonthMap.put(2088, new int[]{0, 30, 31, 32, 32, 30, 31, 30, 30, 29, 30, 30, 30});
        daysInMonthMap.put(2089, new int[]{0, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30});
        daysInMonthMap.put(2090, new int[]{0, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30});
        /* *//*new*//*
        // based on https://github.com/bahadurbaniya/Date-Converter-Bikram-Sambat-to-English-Date/blob/master/src/main/java/np/com/converter/date/nepali/Lookup.java
        daysInMonthMap.put(2091, new int[]{31, 31, 32, 31, 31, 31, 30, 30, 29, 30, 30, 30});// 2091
        daysInMonthMap.put(2092, new int[]{31, 31, 32, 32, 31, 30, 30, 30, 29, 30, 30, 30});// 2092
        daysInMonthMap.put(2093, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30});// 2093
        daysInMonthMap.put(2094, new int[]{31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30});// 2094
        daysInMonthMap.put(2095, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 30, 30, 30});// 2095
        daysInMonthMap.put(2096, new int[]{30, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});// 2096
        daysInMonthMap.put(2097, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30});// 2097
        daysInMonthMap.put(2098, new int[]{31, 31, 32, 31, 31, 31, 29, 30, 29, 30, 30, 31});// 2098
        daysInMonthMap.put(2099, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 29, 30, 30, 30});// 2099
        daysInMonthMap.put(2100, new int[]{31, 32, 31, 32, 30, 31, 30, 29, 30, 29, 30, 30});// 2100
        */
//        return daysInMonthMap;
    }

    protected void getStartWeekDayMonthMap() {
//        if (startWeekDayMonthMap != null) return startWeekDayMonthMap;
        SparseArray<int[]> startWeekDayMonthMap = new SparseArray<>();

        /*
         The 0s at index 0 are dummy values so as to make the int array of
         days in months seems more intuitive that index 1 refers to first
         month "Baisakh", index 2 refers to second month "Jesth" and so on.
         */

        // based on www.ashesh.com.np/neplai-date-converter
        startWeekDayMonthMap.put(1970, new int[]{0, 1, 4, 7, 4, 7, 3, 6, 1, 2, 4, 5, 7});
        startWeekDayMonthMap.put(1971, new int[]{0, 2, 5, 1, 5, 1, 5, 7, 2, 3, 5, 6, 1});
        startWeekDayMonthMap.put(1972, new int[]{0, 3, 6, 3, 6, 3, 6, 1, 3, 5, 6, 7, 2});
        startWeekDayMonthMap.put(1973, new int[]{0, 5, 7, 4, 7, 4, 7, 2, 4, 6, 7, 2, 3});
        startWeekDayMonthMap.put(1974, new int[]{0, 6, 1, 5, 2, 5, 1, 4, 6, 7, 2, 3, 5});
        startWeekDayMonthMap.put(1975, new int[]{0, 7, 3, 6, 3, 7, 3, 5, 7, 1, 3, 4, 6});
        startWeekDayMonthMap.put(1976, new int[]{0, 1, 4, 1, 4, 1, 4, 6, 1, 3, 4, 5, 7});
        startWeekDayMonthMap.put(1977, new int[]{0, 3, 5, 2, 5, 2, 5, 1, 2, 4, 5, 7, 1});
        startWeekDayMonthMap.put(1978, new int[]{0, 4, 7, 3, 7, 3, 6, 2, 4, 5, 7, 1, 3});
        startWeekDayMonthMap.put(1979, new int[]{0, 5, 1, 4, 1, 5, 1, 3, 5, 6, 1, 2, 4});
        startWeekDayMonthMap.put(1980, new int[]{0, 6, 2, 6, 2, 6, 2, 4, 6, 1, 2, 3, 5});
        startWeekDayMonthMap.put(1981, new int[]{0, 1, 4, 7, 3, 7, 3, 6, 7, 2, 4, 5, 7});
        startWeekDayMonthMap.put(1982, new int[]{0, 2, 5, 1, 5, 1, 4, 7, 2, 3, 5, 6, 1});
        startWeekDayMonthMap.put(1983, new int[]{0, 3, 6, 2, 6, 3, 6, 1, 3, 4, 6, 7, 2});
        startWeekDayMonthMap.put(1984, new int[]{0, 4, 7, 4, 7, 4, 7, 2, 4, 6, 7, 1, 3});
        startWeekDayMonthMap.put(1985, new int[]{0, 6, 2, 5, 1, 5, 1, 4, 5, 7, 2, 3, 5});
        startWeekDayMonthMap.put(1986, new int[]{0, 7, 3, 6, 3, 6, 2, 5, 7, 1, 3, 4, 6});
        startWeekDayMonthMap.put(1987, new int[]{0, 1, 4, 1, 4, 1, 4, 6, 1, 2, 4, 5, 7});
        startWeekDayMonthMap.put(1988, new int[]{0, 2, 5, 2, 5, 2, 5, 7, 2, 4, 5, 6, 1});
        startWeekDayMonthMap.put(1989, new int[]{0, 4, 7, 3, 6, 3, 6, 2, 4, 5, 7, 1, 3});
        startWeekDayMonthMap.put(1990, new int[]{0, 5, 1, 4, 1, 4, 7, 3, 5, 6, 1, 2, 4});
        startWeekDayMonthMap.put(1991, new int[]{0, 6, 2, 6, 2, 6, 2, 4, 6, 1, 2, 3, 5});
        startWeekDayMonthMap.put(1992, new int[]{0, 7, 3, 7, 3, 7, 3, 5, 7, 2, 3, 5, 6});
        startWeekDayMonthMap.put(1993, new int[]{0, 2, 5, 1, 4, 1, 4, 7, 2, 3, 5, 6, 1});
        startWeekDayMonthMap.put(1994, new int[]{0, 3, 6, 2, 6, 2, 5, 1, 3, 4, 6, 7, 2});
        startWeekDayMonthMap.put(1995, new int[]{0, 4, 7, 4, 7, 4, 7, 2, 4, 6, 7, 1, 3});
        startWeekDayMonthMap.put(1996, new int[]{0, 5, 1, 5, 1, 5, 1, 3, 5, 7, 1, 3, 4});
        startWeekDayMonthMap.put(1997, new int[]{0, 7, 3, 6, 3, 6, 2, 5, 7, 1, 3, 4, 6});
        startWeekDayMonthMap.put(1998, new int[]{0, 1, 4, 7, 4, 7, 3, 6, 1, 2, 4, 5, 7});
        startWeekDayMonthMap.put(1999, new int[]{0, 2, 5, 2, 5, 2, 5, 7, 2, 4, 5, 6, 1});

        /*old*/
        startWeekDayMonthMap.put(2000, new int[]{0, 4, 6, 3, 6, 3, 6, 1, 3, 5, 6, 1, 2});
        startWeekDayMonthMap.put(2001, new int[]{0, 5, 1, 4, 1, 4, 7, 3, 5, 6, 1, 2, 4});
        startWeekDayMonthMap.put(2002, new int[]{0, 6, 2, 5, 2, 6, 2, 4, 6, 7, 2, 3, 5});
        startWeekDayMonthMap.put(2003, new int[]{0, 7, 3, 7, 3, 7, 3, 5, 7, 2, 3, 4, 6});
        startWeekDayMonthMap.put(2004, new int[]{0, 2, 4, 1, 4, 1, 4, 6, 1, 3, 4, 6, 7});
        startWeekDayMonthMap.put(2005, new int[]{0, 3, 6, 2, 6, 2, 5, 1, 3, 4, 6, 7, 2});
        startWeekDayMonthMap.put(2006, new int[]{0, 4, 7, 3, 7, 4, 7, 2, 4, 5, 7, 1, 3});
        startWeekDayMonthMap.put(2007, new int[]{0, 5, 1, 5, 1, 5, 1, 3, 5, 7, 1, 2, 4});
        startWeekDayMonthMap.put(2008, new int[]{0, 7, 3, 6, 2, 6, 2, 5, 6, 1, 3, 4, 5});
        startWeekDayMonthMap.put(2009, new int[]{0, 1, 4, 7, 4, 7, 3, 6, 1, 2, 4, 5, 7});
        startWeekDayMonthMap.put(2010, new int[]{0, 2, 5, 1, 5, 2, 5, 7, 2, 3, 5, 6, 1});
        startWeekDayMonthMap.put(2011, new int[]{0, 3, 6, 3, 6, 3, 6, 1, 3, 5, 6, 7, 2});
        startWeekDayMonthMap.put(2012, new int[]{0, 5, 1, 4, 7, 4, 7, 3, 4, 6, 1, 2, 4});
        startWeekDayMonthMap.put(2013, new int[]{0, 6, 2, 5, 2, 5, 1, 4, 6, 7, 2, 3, 5});
        startWeekDayMonthMap.put(2014, new int[]{0, 7, 3, 6, 3, 7, 3, 5, 7, 1, 3, 4, 6});
        startWeekDayMonthMap.put(2015, new int[]{0, 1, 4, 1, 4, 1, 4, 6, 1, 3, 4, 5, 7});
        startWeekDayMonthMap.put(2016, new int[]{0, 3, 6, 2, 5, 2, 5, 1, 2, 4, 6, 7, 2});
        startWeekDayMonthMap.put(2017, new int[]{0, 4, 7, 3, 7, 3, 6, 2, 4, 5, 7, 1, 3});
        startWeekDayMonthMap.put(2018, new int[]{0, 5, 1, 5, 1, 5, 1, 3, 5, 6, 1, 2, 4});
        startWeekDayMonthMap.put(2019, new int[]{0, 6, 2, 6, 2, 6, 2, 4, 6, 1, 2, 4, 5});
        startWeekDayMonthMap.put(2020, new int[]{0, 1, 4, 7, 3, 7, 3, 6, 1, 2, 4, 5, 7});
        startWeekDayMonthMap.put(2021, new int[]{0, 2, 5, 1, 5, 1, 4, 7, 2, 3, 5, 6, 1});
        startWeekDayMonthMap.put(2022, new int[]{0, 3, 6, 3, 6, 3, 6, 1, 3, 5, 6, 7, 2});
        startWeekDayMonthMap.put(2023, new int[]{0, 4, 7, 4, 7, 4, 7, 2, 4, 6, 7, 2, 3});
        startWeekDayMonthMap.put(2024, new int[]{0, 6, 2, 5, 1, 5, 1, 4, 6, 7, 2, 3, 5});
        startWeekDayMonthMap.put(2025, new int[]{0, 7, 3, 6, 3, 6, 2, 5, 7, 1, 3, 4, 6});
        startWeekDayMonthMap.put(2026, new int[]{0, 1, 4, 1, 4, 1, 4, 6, 1, 3, 4, 5, 7});
        startWeekDayMonthMap.put(2027, new int[]{0, 3, 5, 2, 5, 2, 5, 7, 2, 4, 5, 7, 1});
        startWeekDayMonthMap.put(2028, new int[]{0, 4, 7, 3, 7, 3, 6, 2, 4, 5, 7, 1, 3});
        startWeekDayMonthMap.put(2029, new int[]{0, 5, 1, 4, 1, 4, 1, 3, 5, 6, 1, 2, 4});
        startWeekDayMonthMap.put(2030, new int[]{0, 6, 2, 6, 2, 6, 2, 4, 6, 1, 2, 3, 5});
        startWeekDayMonthMap.put(2031, new int[]{0, 1, 3, 7, 3, 7, 3, 5, 7, 2, 3, 5, 6});
        startWeekDayMonthMap.put(2032, new int[]{0, 2, 5, 1, 5, 1, 4, 7, 2, 3, 5, 6, 1});
        startWeekDayMonthMap.put(2033, new int[]{0, 3, 6, 2, 6, 3, 6, 1, 3, 4, 6, 7, 2});
        startWeekDayMonthMap.put(2034, new int[]{0, 4, 7, 4, 7, 4, 7, 2, 4, 6, 7, 1, 3});
        startWeekDayMonthMap.put(2035, new int[]{0, 6, 1, 5, 1, 5, 1, 4, 5, 7, 2, 3, 4});
        startWeekDayMonthMap.put(2036, new int[]{0, 7, 3, 6, 3, 6, 2, 5, 7, 1, 3, 4, 6});
        startWeekDayMonthMap.put(2037, new int[]{0, 1, 4, 7, 4, 1, 4, 6, 1, 2, 4, 5, 7});
        startWeekDayMonthMap.put(2038, new int[]{0, 2, 5, 2, 5, 2, 5, 7, 2, 4, 5, 6, 1});
        startWeekDayMonthMap.put(2039, new int[]{0, 4, 7, 3, 6, 3, 6, 2, 3, 5, 7, 1, 3});
        startWeekDayMonthMap.put(2040, new int[]{0, 5, 1, 4, 1, 4, 7, 3, 5, 6, 1, 2, 4});
        startWeekDayMonthMap.put(2041, new int[]{0, 6, 2, 5, 2, 6, 2, 4, 6, 7, 2, 3, 5});
        startWeekDayMonthMap.put(2042, new int[]{0, 7, 3, 7, 3, 7, 3, 5, 7, 2, 3, 4, 6});
        startWeekDayMonthMap.put(2043, new int[]{0, 2, 5, 1, 4, 1, 4, 7, 1, 3, 5, 6, 1});
        startWeekDayMonthMap.put(2044, new int[]{0, 3, 6, 2, 6, 2, 5, 1, 3, 4, 6, 7, 2});
        startWeekDayMonthMap.put(2045, new int[]{0, 4, 7, 4, 7, 4, 7, 2, 4, 5, 7, 1, 3});
        startWeekDayMonthMap.put(2046, new int[]{0, 5, 1, 5, 1, 5, 1, 3, 5, 7, 1, 2, 4});
        startWeekDayMonthMap.put(2047, new int[]{0, 7, 3, 6, 2, 6, 2, 5, 7, 1, 3, 4, 6});
        startWeekDayMonthMap.put(2048, new int[]{0, 1, 4, 7, 4, 7, 3, 6, 1, 2, 4, 5, 7});
        startWeekDayMonthMap.put(2049, new int[]{0, 2, 5, 2, 5, 2, 5, 7, 2, 4, 5, 6, 1});
        startWeekDayMonthMap.put(2050, new int[]{0, 3, 6, 3, 6, 3, 6, 1, 3, 5, 6, 1, 2});
        startWeekDayMonthMap.put(2051, new int[]{0, 5, 1, 4, 7, 4, 7, 3, 5, 6, 1, 2, 4});
        startWeekDayMonthMap.put(2052, new int[]{0, 6, 2, 5, 2, 5, 1, 4, 6, 7, 2, 3, 5});
        startWeekDayMonthMap.put(2053, new int[]{0, 7, 3, 7, 3, 7, 3, 5, 7, 2, 3, 4, 6});
        startWeekDayMonthMap.put(2054, new int[]{0, 1, 4, 1, 4, 1, 4, 6, 1, 3, 4, 6, 7});
        startWeekDayMonthMap.put(2055, new int[]{0, 3, 6, 2, 6, 2, 5, 1, 3, 4, 6, 7, 2});
        startWeekDayMonthMap.put(2056, new int[]{0, 4, 7, 3, 7, 3, 7, 2, 4, 5, 7, 1, 3});
        startWeekDayMonthMap.put(2057, new int[]{0, 5, 1, 5, 1, 5, 1, 3, 5, 7, 1, 2, 4});
        startWeekDayMonthMap.put(2058, new int[]{0, 7, 2, 6, 2, 6, 2, 4, 6, 1, 2, 4, 5});
        startWeekDayMonthMap.put(2059, new int[]{0, 1, 4, 7, 4, 7, 3, 6, 1, 2, 4, 5, 7});
        startWeekDayMonthMap.put(2060, new int[]{0, 2, 5, 1, 5, 2, 5, 7, 2, 3, 5, 6, 1});
        startWeekDayMonthMap.put(2061, new int[]{0, 3, 6, 3, 6, 3, 6, 1, 3, 5, 6, 7, 2});
        startWeekDayMonthMap.put(2062, new int[]{0, 5, 7, 4, 7, 4, 7, 3, 4, 6, 7, 2, 3});
        startWeekDayMonthMap.put(2063, new int[]{0, 6, 2, 5, 2, 5, 1, 4, 6, 7, 2, 3, 5});
        startWeekDayMonthMap.put(2064, new int[]{0, 7, 3, 6, 3, 7, 3, 5, 7, 1, 3, 4, 6});
        startWeekDayMonthMap.put(2065, new int[]{0, 1, 4, 1, 4, 1, 4, 6, 1, 3, 4, 5, 7});
        startWeekDayMonthMap.put(2066, new int[]{0, 3, 6, 2, 5, 2, 5, 1, 2, 4, 6, 7, 1});
        startWeekDayMonthMap.put(2067, new int[]{0, 4, 7, 3, 7, 3, 6, 2, 4, 5, 7, 1, 3});
        startWeekDayMonthMap.put(2068, new int[]{0, 5, 1, 4, 1, 5, 1, 3, 5, 6, 1, 2, 4});
        startWeekDayMonthMap.put(2069, new int[]{0, 6, 2, 6, 2, 6, 2, 4, 6, 1, 2, 3, 5});
        startWeekDayMonthMap.put(2070, new int[]{0, 1, 4, 7, 3, 7, 3, 6, 7, 2, 4, 5, 7});
        startWeekDayMonthMap.put(2071, new int[]{0, 2, 5, 1, 5, 1, 4, 7, 2, 3, 5, 6, 1});
        startWeekDayMonthMap.put(2072, new int[]{0, 3, 6, 3, 6, 3, 6, 1, 3, 4, 6, 7, 2});
        startWeekDayMonthMap.put(2073, new int[]{0, 4, 7, 4, 7, 4, 7, 2, 4, 6, 7, 1, 3});
        startWeekDayMonthMap.put(2074, new int[]{0, 6, 2, 5, 1, 5, 1, 4, 6, 7, 2, 3, 5});
        startWeekDayMonthMap.put(2075, new int[]{0, 7, 3, 6, 3, 6, 2, 5, 7, 1, 3, 4, 6});
        startWeekDayMonthMap.put(2076, new int[]{0, 1, 4, 1, 4, 1, 4, 6, 1, 3, 4, 5, 7});
        startWeekDayMonthMap.put(2077, new int[]{0, 2, 5, 2, 5, 2, 5, 7, 2, 4, 5, 7, 1});
        startWeekDayMonthMap.put(2078, new int[]{0, 4, 7, 3, 6, 3, 6, 2, 4, 5, 7, 1, 3});
        startWeekDayMonthMap.put(2079, new int[]{0, 5, 1, 4, 1, 4, 7, 3, 5, 6, 1, 2, 4});
        startWeekDayMonthMap.put(2080, new int[]{0, 6, 2, 6, 2, 6, 2, 4, 6, 1, 2, 3, 5});
        startWeekDayMonthMap.put(2081, new int[]{0, 7, 3, 6, 3, 7, 3, 5, 7, 2, 3, 5, 7});
        startWeekDayMonthMap.put(2082, new int[]{0, 2, 4, 1, 4, 1, 4, 6, 1, 3, 4, 6, 1});
        startWeekDayMonthMap.put(2083, new int[]{0, 3, 6, 2, 6, 2, 5, 7, 2, 4, 5, 7, 2});
        startWeekDayMonthMap.put(2084, new int[]{0, 4, 7, 3, 7, 3, 6, 1, 3, 5, 6, 1, 3});
        startWeekDayMonthMap.put(2085, new int[]{0, 5, 1, 5, 1, 5, 7, 3, 5, 7, 1, 3, 5});
        startWeekDayMonthMap.put(2086, new int[]{0, 7, 2, 6, 2, 6, 2, 4, 6, 1, 2, 4, 6});
        startWeekDayMonthMap.put(2087, new int[]{0, 1, 4, 7, 4, 7, 3, 6, 1, 3, 4, 6, 1});
        startWeekDayMonthMap.put(2088, new int[]{0, 3, 5, 1, 5, 2, 4, 7, 2, 4, 5, 7, 2});
        startWeekDayMonthMap.put(2089, new int[]{0, 4, 6, 3, 6, 3, 6, 1, 3, 5, 6, 1, 3});
        startWeekDayMonthMap.put(2090, new int[]{0, 5, 7, 4, 7, 4, 7, 2, 4, 6, 7, 2, 4});
        /*  *//*start of new but dummy data just for test todo fix with real data*//*
        startWeekDayMonthMap.put(2091, new int[]{0, 5, 1, 4, 1, 4, 7, 3, 5, 6, 1, 2, 4});
        startWeekDayMonthMap.put(2092, new int[]{0, 6, 2, 5, 2, 6, 2, 4, 6, 7, 2, 3, 5});
        startWeekDayMonthMap.put(2093, new int[]{0, 7, 3, 7, 3, 7, 3, 5, 7, 2, 3, 4, 6});
        startWeekDayMonthMap.put(2094, new int[]{0, 2, 4, 1, 4, 1, 4, 6, 1, 3, 4, 6, 7});
        startWeekDayMonthMap.put(2095, new int[]{0, 3, 6, 2, 6, 2, 5, 1, 3, 4, 6, 7, 2});
        startWeekDayMonthMap.put(2096, new int[]{0, 4, 7, 3, 7, 4, 7, 2, 4, 5, 7, 1, 3});
        startWeekDayMonthMap.put(2097, new int[]{0, 5, 1, 5, 1, 5, 1, 3, 5, 7, 1, 2, 4});
        startWeekDayMonthMap.put(2098, new int[]{0, 7, 3, 6, 2, 6, 2, 5, 6, 1, 3, 4, 5});
        startWeekDayMonthMap.put(2099, new int[]{0, 1, 4, 7, 4, 7, 3, 6, 1, 2, 4, 5, 7});
        startWeekDayMonthMap.put(2100, new int[]{0, 4, 6, 3, 6, 3, 6, 1, 3, 5, 6, 1, 2});
        */
//        return startWeekDayMonthMap;
    }

}
