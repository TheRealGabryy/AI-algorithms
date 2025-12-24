/*
 * Copyright 2025 Gabriele Bolognese
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
 */

package Transformer.Utils;

import Transformer.Model.Dataset;
import Transformer.Model.Tokenizer;

/*
* This Class job is to coordinate the functionalities of all other classes. this class has no private variables
*
* Instead of declaring too many classes in the main, we declare a manager clas, that handles everything.
*
* On the main we just use a copy of the classes, without accessing them directly*/
public class Manager {
    private final Tokenizer tokenizer = new Tokenizer(1);
    private final Dataset dataset = new Dataset();

    public Tokenizer getTokenizer() {
        return tokenizer;
    }

    public Dataset getDataset() {
        return dataset;
    }
}
