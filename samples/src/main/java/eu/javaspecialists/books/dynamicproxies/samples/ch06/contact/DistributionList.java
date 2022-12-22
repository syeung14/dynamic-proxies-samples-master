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

package eu.javaspecialists.books.dynamicproxies.samples.ch06.contact;

// tag::listing[]
import java.util.*;

public class DistributionList implements Contact {
  private final Collection<Contact> contacts = new ArrayList<>();

  @Override
  public boolean add(Contact c) {
    return contacts.add(c);
  }
  @Override
  public boolean remove(Contact c) {
    return contacts.remove(c);
  }
  @Override
  public void sendMail(String body) {
    contacts.forEach(contact -> contact.sendMail(body));
  }
  @Override
  public int count() {
    return contacts.stream().mapToInt(Contact::count).sum();
  }
}
// end::listing[]