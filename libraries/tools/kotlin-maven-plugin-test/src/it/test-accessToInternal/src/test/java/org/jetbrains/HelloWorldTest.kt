/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains

import org.junit.Test

import junit.framework.Assert.assertEquals

class HelloWorldTest {

    @Test
    fun greeting() {
        assertEquals("Hello, World!", getGreeting())
    }

    @Test
    fun accessToInternal() {
        assertEquals("CONST", CONST)

        assertEquals("foo", PublicClass().foo())
        assertEquals("bar", PublicClass().bar)

        val data = InternalDataClass(10, 20)
        assertEquals(10, data.x)
        assertEquals(20, data.y)
    }
}
