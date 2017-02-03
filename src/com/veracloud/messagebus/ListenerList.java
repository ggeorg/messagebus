/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.veracloud.messagebus;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Abstract base class for listener lists.
 * 
 * @author ggeorg
 *
 * @param <T>
 */
public class ListenerList<T> implements Iterable<T> {

  private final List<T> list;

  public ListenerList() {
    list = new CopyOnWriteArrayList<T>();
  }

  public void add(T listener) {
    if (indexOf(listener) >= 0) {
      // System.err.println("Duplicate listener " + listener + " added to " +
      // this);
      return;
    }

    list.add(listener);
  }

  public void remove(T listener) {
    int index = indexOf(listener);

    if (index < 0) {
      // System.err.println("Nonexistent listener " + listener + " removed from
      // " + this);
      return;
    }

    list.remove(index);
  }

  private int indexOf(T listener) {
    return list.indexOf(listener);
  }

  public boolean contains(T listener) {
    return list.contains(listener);
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public int size() {
    return list.size();
  }

  public T get(int index) {
    return list.get(index);
  }

  @Override
  public Iterator<T> iterator() {
    return list.iterator();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("ListenerList [");

    int i = 0;
    for (T item : this) {
      if (i > 0) {
        sb.append(", ");
      }

      sb.append(item);
      i++;
    }

    sb.append("]");

    return sb.toString();
  }

}