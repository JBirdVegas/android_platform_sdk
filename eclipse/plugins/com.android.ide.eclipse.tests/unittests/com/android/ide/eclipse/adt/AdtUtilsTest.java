/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Eclipse Public License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.eclipse.org/org/documents/epl-v10.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.ide.eclipse.adt;

import junit.framework.TestCase;

@SuppressWarnings("javadoc")
public class AdtUtilsTest extends TestCase {
    public void testEndsWithIgnoreCase() {
        assertTrue(AdtUtils.endsWithIgnoreCase("foo", "foo"));
        assertTrue(AdtUtils.endsWithIgnoreCase("foo", "Foo"));
        assertTrue(AdtUtils.endsWithIgnoreCase("foo", "foo"));
        assertTrue(AdtUtils.endsWithIgnoreCase("Barfoo", "foo"));
        assertTrue(AdtUtils.endsWithIgnoreCase("BarFoo", "foo"));
        assertTrue(AdtUtils.endsWithIgnoreCase("BarFoo", "foO"));

        assertFalse(AdtUtils.endsWithIgnoreCase("foob", "foo"));
        assertFalse(AdtUtils.endsWithIgnoreCase("foo", "fo"));
    }

    public void testStartsWithIgnoreCase() {
        assertTrue(AdtUtils.startsWithIgnoreCase("foo", "foo"));
        assertTrue(AdtUtils.startsWithIgnoreCase("foo", "Foo"));
        assertTrue(AdtUtils.startsWithIgnoreCase("foo", "foo"));
        assertTrue(AdtUtils.startsWithIgnoreCase("barfoo", "bar"));
        assertTrue(AdtUtils.startsWithIgnoreCase("BarFoo", "bar"));
        assertTrue(AdtUtils.startsWithIgnoreCase("BarFoo", "bAr"));

        assertFalse(AdtUtils.startsWithIgnoreCase("bfoo", "foo"));
        assertFalse(AdtUtils.startsWithIgnoreCase("fo", "foo"));
    }

    public void testStartsWith() {
        assertTrue(AdtUtils.startsWith("foo", 0, "foo"));
        assertTrue(AdtUtils.startsWith("foo", 0, "Foo"));
        assertTrue(AdtUtils.startsWith("Foo", 0, "foo"));
        assertTrue(AdtUtils.startsWith("aFoo", 1, "foo"));

        assertFalse(AdtUtils.startsWith("aFoo", 0, "foo"));
        assertFalse(AdtUtils.startsWith("aFoo", 2, "foo"));
    }

    public void testEndsWith() {
        assertTrue(AdtUtils.endsWith("foo", "foo"));
        assertTrue(AdtUtils.endsWith("foobar", "obar"));
        assertTrue(AdtUtils.endsWith("foobar", "bar"));
        assertTrue(AdtUtils.endsWith("foobar", "ar"));
        assertTrue(AdtUtils.endsWith("foobar", "r"));
        assertTrue(AdtUtils.endsWith("foobar", ""));

        assertTrue(AdtUtils.endsWith(new StringBuilder("foobar"), "bar"));
        assertTrue(AdtUtils.endsWith(new StringBuilder("foobar"), new StringBuffer("obar")));
        assertTrue(AdtUtils.endsWith("foobar", new StringBuffer("obar")));

        assertFalse(AdtUtils.endsWith("foo", "fo"));
        assertFalse(AdtUtils.endsWith("foobar", "Bar"));
        assertFalse(AdtUtils.endsWith("foobar", "longfoobar"));
    }

    public void testEndsWith2() {
        assertTrue(AdtUtils.endsWith("foo", "foo".length(), "foo"));
        assertTrue(AdtUtils.endsWith("foo", "fo".length(), "fo"));
        assertTrue(AdtUtils.endsWith("foo", "f".length(), "f"));
    }

    public void testStripWhitespace() {
        assertEquals("foo", AdtUtils.stripWhitespace("foo"));
        assertEquals("foobar", AdtUtils.stripWhitespace("foo bar"));
        assertEquals("foobar", AdtUtils.stripWhitespace("  foo bar  \n\t"));
    }

    public void testExtractClassName() {
        assertEquals("Foo", AdtUtils.extractClassName("foo"));
        assertEquals("Foobar", AdtUtils.extractClassName("foo bar"));
        assertEquals("JavasTypeSystem", AdtUtils.extractClassName("Java's Type System"));
        assertEquals("Foo", AdtUtils.extractClassName("1foo "));
    }

    public void testStripAllExtensions() {
        assertEquals("", AdtUtils.stripAllExtensions(""));
        assertEquals("foobar", AdtUtils.stripAllExtensions("foobar"));
        assertEquals("foobar", AdtUtils.stripAllExtensions("foobar.png"));
        assertEquals("foobar", AdtUtils.stripAllExtensions("foobar.9.png"));
        assertEquals(".profile", AdtUtils.stripAllExtensions(".profile"));
    }

    public void testStripLastExtension() {
        assertEquals("", AdtUtils.stripLastExtension(""));
        assertEquals("foobar", AdtUtils.stripLastExtension("foobar"));
        assertEquals("foobar", AdtUtils.stripLastExtension("foobar.png"));
        assertEquals("foobar.9", AdtUtils.stripLastExtension("foobar.9.png"));
        assertEquals(".profile", AdtUtils.stripLastExtension(".profile"));
    }

    public void testCapitalize() {
        assertEquals("UPPER", AdtUtils.capitalize("UPPER"));
        assertEquals("Lower", AdtUtils.capitalize("lower"));
        assertEquals("Capital", AdtUtils.capitalize("Capital"));
        assertEquals("CamelCase", AdtUtils.capitalize("camelCase"));
        assertEquals("", AdtUtils.capitalize(""));
        assertSame("Foo", AdtUtils.capitalize("Foo"));
        assertNull(null, AdtUtils.capitalize(null));
    }

    public void testStripSuffix() {
        assertEquals("Foo", AdtUtils.stripSuffix("Foo", ""));
        assertEquals("Fo", AdtUtils.stripSuffix("Foo", "o"));
        assertEquals("F", AdtUtils.stripSuffix("Fo", "o"));
        assertEquals("", AdtUtils.stripSuffix("Foo", "Foo"));
        assertEquals("LinearLayout_Layout",
                AdtUtils.stripSuffix("LinearLayout_LayoutParams", "Params"));
        assertEquals("Foo", AdtUtils.stripSuffix("Foo", "Bar"));
    }
}
