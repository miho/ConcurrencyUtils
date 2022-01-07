/*
 * Copyright 2022 Michael Hoffer <info@michaelhoffer.de>. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * If you use this software for scientific research then please cite the following publication(s):
 *
 * M. Hoffer, C. Poliwoda, & G. Wittum. (2013). Visual reflection library:
 * a framework for declarative GUI programming on the Java platform.
 * Computing and Visualization in Science, 2013, 16(4),
 * 181–192. http://doi.org/10.1007/s00791-014-0230-y
 */
package eu.mihosoft.concurrencyutils.vmfmodel;

import eu.mihosoft.vmf.core.Container;
import eu.mihosoft.vmf.core.Contains;
import eu.mihosoft.vmf.core.DelegateTo;

interface Counter {

    int getValue();

    @DelegateTo(className = "eu.mihosoft.concurrencyutils.CounterBehavior")
    void inc();

    @DelegateTo(className = "eu.mihosoft.concurrencyutils.CounterBehavior")
    void dec();

    @DelegateTo(className = "eu.mihosoft.concurrencyutils.CounterBehavior")
    void reset();

    @Container(opposite = "counter")
    CounterParent getOwner();

}

interface CounterParent {

    @Contains(opposite = "owner")
    Counter getCounter();

}
