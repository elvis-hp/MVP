/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.sukenda.mvp.home;

import com.sukenda.mvp.entity.Dummy;

import java.util.ArrayList;
import java.util.List;

public class HomeInteractionImpl implements HomeInteraction {

    @Override
    public void findItems(final OnFinishedListener listener) {
        listener.onFinished(createArrayList());
    }

    private List<Dummy> createArrayList() {
        List<Dummy> dummies = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dummies.add(new Dummy());
        }

        return dummies;
    }
}
