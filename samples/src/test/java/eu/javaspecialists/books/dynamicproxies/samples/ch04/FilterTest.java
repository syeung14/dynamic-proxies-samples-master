/*
 * Copyright (C) 2020 Heinz Max Kabutz
 *
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.  Heinz Max Kabutz
 * licenses this file to you under the Apache License, Version
 * 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the
 * License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */

package eu.javaspecialists.books.dynamicproxies.samples.ch04;

import eu.javaspecialists.books.dynamicproxies.*;
import eu.javaspecialists.books.dynamicproxies.samples.ch04.immutablecollection.*;
import org.junit.*;

import java.util.*;

// To run this test, add the following to the VM arguments:
// --add-reads eu.javaspecialists.books.dynamicproxies=eu.javaspecialists.books.dynamicproxies.samples
public class FilterTest {
  @Test(expected = IllegalArgumentException.class)
  public void testBadFilter() {
    Proxies.filter(Collection.class, new Object());
  }
  @Test
  public void testGoodFilters() {
    Proxies.filter(Collection.class, new ArrayList<>());
    Proxies.filter(ImmutableCollection.class, new ArrayList<>());
    Proxies.filter(Collection.class, new ArrayDeque<>());
  }
}
