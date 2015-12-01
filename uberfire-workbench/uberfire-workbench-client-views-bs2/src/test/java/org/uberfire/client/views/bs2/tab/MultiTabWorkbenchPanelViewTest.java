/*
 * Copyright 2015 JBoss, by Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.client.views.bs2.tab;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Element;
import com.google.gwtmockito.GwtMockitoTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.uberfire.client.views.bs2.maximize.MaximizeToggleButton;
import org.uberfire.client.workbench.widgets.listbar.ResizeFlowPanel;
import org.uberfire.mvp.Command;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(GwtMockitoTestRunner.class)
public class MultiTabWorkbenchPanelViewTest {

    @InjectMocks
    private MultiTabWorkbenchPanelView view;

    @Mock
    private UberTabPanel uberTabPanel;

    @Mock
    private MaximizeToggleButton maximizeButton;

    @Mock
    private ResizeFlowPanel partViewContainer;

    @Before
    public void setup() {
        Element uberTabPanelElement = mock( Element.class );
        Style uberTabPanelElementStyle = mock( Style.class );
        when( uberTabPanel.getElement() ).thenReturn( uberTabPanelElement );
        when( uberTabPanelElement.getStyle() ).thenReturn( uberTabPanelElementStyle );
    }

    @Test
    public void setupWidget() {
        view.setupWidget();
        //assert event handlers
        verify( uberTabPanel ).addSelectionHandler(any(SelectionHandler.class));
        verify( uberTabPanel ).addOnFocusHandler( any( Command.class ));
    }

}