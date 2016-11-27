package org.unidal.cat.message.internals;

import java.util.concurrent.atomic.AtomicBoolean;

import org.unidal.cat.config.internals.ClientSettings;
import org.unidal.cat.message.MessagePolicy;
import org.unidal.lookup.annotation.Inject;
import org.unidal.lookup.annotation.Named;

@Named(type = MessagePolicy.class)
public class DefaultMessagePolicy implements MessagePolicy {
   @Inject
   private ClientSettings m_settings;

   private AtomicBoolean m_enabled = new AtomicBoolean(true);

   @Override
   public boolean isEnabled() {
      return m_enabled.get() && m_settings.getDomain() != null;
   }

   @Override
   public void disable() {
      m_enabled.set(false);
   }
}
