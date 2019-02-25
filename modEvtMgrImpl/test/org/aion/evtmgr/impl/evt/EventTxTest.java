package org.aion.evtmgr.impl.evt;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;

import org.aion.evtmgr.IEvent;
import org.junit.Test;

public class EventTxTest {

    @Test
    public void testPENDINGTXSTATECHANGE0() {
        EventTx eventTx = new EventTx(EventTx.CALLBACK.PENDINGTXSTATECHANGE0);

        assertEquals(IEvent.TYPE.TX0.getValue(), eventTx.getEventType());
        assertEquals(0, eventTx.getCallbackType());
    }

    @Test
    public void testPENDINGTXUPDATE0() {
        EventTx eventTx = new EventTx(EventTx.CALLBACK.PENDINGTXUPDATE0);

        assertEquals(IEvent.TYPE.TX0.getValue(), eventTx.getEventType());
        assertEquals(1, eventTx.getCallbackType());
    }

    @Test
    public void testPENDINGTXRECEIVED0() {
        EventTx eventTx = new EventTx(EventTx.CALLBACK.PENDINGTXRECEIVED0);

        assertEquals(IEvent.TYPE.TX0.getValue(), eventTx.getEventType());
        assertEquals(2, eventTx.getCallbackType());
    }

    @Test
    public void testTXEXECUTED0() {
        EventTx eventTx = new EventTx(EventTx.CALLBACK.TXEXECUTED0);

        assertEquals(IEvent.TYPE.TX0.getValue(), eventTx.getEventType());
        assertEquals(3, eventTx.getCallbackType());
    }

    @Test
    public void testTXBACKUP0() {
        EventTx eventTx = new EventTx(EventTx.CALLBACK.TXBACKUP0);

        assertEquals(IEvent.TYPE.TX0.getValue(), eventTx.getEventType());
        assertEquals(4, eventTx.getCallbackType());
    }

    @Test
    public void testCALLBACK() {
        assertEquals(EventTx.CALLBACK.PENDINGTXSTATECHANGE0, EventTx.CALLBACK.GETCALLBACK(0));
        assertEquals(EventTx.CALLBACK.PENDINGTXUPDATE0, EventTx.CALLBACK.GETCALLBACK(1));
        assertEquals(EventTx.CALLBACK.PENDINGTXRECEIVED0, EventTx.CALLBACK.GETCALLBACK(2));
        assertEquals(EventTx.CALLBACK.TXEXECUTED0, EventTx.CALLBACK.GETCALLBACK(3));
        assertEquals(EventTx.CALLBACK.TXBACKUP0, EventTx.CALLBACK.GETCALLBACK(4));

        assertNull(EventTx.CALLBACK.GETCALLBACK(-1));
        assertNull(EventTx.CALLBACK.GETCALLBACK(5));
    }

    @Test
    public void testState() {
        EventTx eventTx1 = new EventTx(EventTx.STATE.DROPPED0, EventTx.CALLBACK.PENDINGTXRECEIVED0);
        assertEquals(EventTx.STATE.DROPPED0.getValue(), eventTx1.getState());

        EventTx eventTx2 =
                new EventTx(EventTx.STATE.NEW_PENDING0, EventTx.CALLBACK.PENDINGTXRECEIVED0);
        assertEquals(EventTx.STATE.NEW_PENDING0.getValue(), eventTx2.getState());

        EventTx eventTx3 = new EventTx(EventTx.STATE.PENDING0, EventTx.CALLBACK.PENDINGTXRECEIVED0);
        assertEquals(EventTx.STATE.PENDING0.getValue(), eventTx3.getState());

        EventTx eventTx4 = new EventTx(EventTx.STATE.INCLUDED, EventTx.CALLBACK.PENDINGTXRECEIVED0);
        assertEquals(EventTx.STATE.INCLUDED.getValue(), eventTx4.getState());
    }

    @Test
    public void testStateCALLBACK() {
        assertEquals(EventTx.STATE.DROPPED0, EventTx.STATE.GETSTATE(0));
        assertEquals(EventTx.STATE.NEW_PENDING0, EventTx.STATE.GETSTATE(1));
        assertEquals(EventTx.STATE.PENDING0, EventTx.STATE.GETSTATE(2));
        assertEquals(EventTx.STATE.INCLUDED, EventTx.STATE.GETSTATE(3));

        assertNull(EventTx.STATE.GETSTATE(-1));
        assertNull(EventTx.STATE.GETSTATE(4));
    }

    @Test
    public void testIsPendingState() {
        assertFalse(EventTx.STATE.DROPPED0.isPending());
        assertTrue(EventTx.STATE.NEW_PENDING0.isPending());
        assertTrue(EventTx.STATE.PENDING0.isPending());
        assertFalse(EventTx.STATE.INCLUDED.isPending());
    }
}
