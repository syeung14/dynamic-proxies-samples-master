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

package eu.javaspecialists.books.dynamicproxies.samples.ch06.appendables;

import java.io.*;

// tag::listing[]
public class WriterAdapter<E extends Appendable
                                 & Flushable
                                 & Closeable>
    extends Writer {
  private final E adaptee;

  public WriterAdapter(E adaptee) {
    this.adaptee = adaptee;
  }
  @Override
  public void write(char[] cbuf, int off, int len)
      throws IOException {
    for (int i = off; i < off + len; i++) {
      adaptee.append(cbuf[i]);
    }
  }
  @Override
  public void flush() throws IOException {
    adaptee.flush();
  }
  @Override
  public void close() throws IOException {
    adaptee.close();
  }
}
// end::listing[]