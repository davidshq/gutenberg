package org.wordpress.mobile.ReactNativeAztec;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Event emitted by Aztec native view when KEYCODE_ENTER is detected.
 */
class ReactAztecEnterEvent extends Event<ReactAztecEnterEvent> {

  private static final String EVENT_NAME = "topTextInputEnter";

  public ReactAztecEnterEvent(int viewId) {
    super(viewId);
  }

  @Override
  public String getEventName() {
    return EVENT_NAME;
  }

  @Override
  public boolean canCoalesce() {
    return false;
  }

  @Override
  public void dispatch(RCTEventEmitter rctEventEmitter) {
    rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }

  private WritableMap serializeEventData() {
    WritableMap eventData = Arguments.createMap();
    eventData.putInt("target", getViewTag());
    return eventData;
  }
}
