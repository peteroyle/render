/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.seam.render.template.nodes;

import javax.enterprise.inject.spi.BeanManager;

import org.jboss.seam.render.util.BeanManagerUtils;
import org.jboss.seam.solder.beanManager.BeanManagerLocator;
import org.mvel2.templates.res.Node;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
@SuppressWarnings("serial")
public abstract class ContextualNode extends Node {
    public ContextualNode() {
        super();
        init();
    }

    public ContextualNode(final int begin, final String name, final char[] template, final int start, final int end,
                          final Node next) {
        super(begin, name, template, start, end, next);
        init();
    }

    public ContextualNode(final int begin, final String name, final char[] template, final int start, final int end) {
        super(begin, name, template, start, end);
        init();
    }

    private void init() {
        BeanManager manager = new BeanManagerLocator().getBeanManager();
        BeanManagerUtils.injectNonContextualInstance(manager, this);
    }

}
