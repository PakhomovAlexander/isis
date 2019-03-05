package org.ro.handler

import org.ro.core.Session
import org.ro.core.event.RoXmlHttpRequest
import org.ro.to.ACTIONS_RUN_FIXTURE_SCRIPT
import org.w3c.xhr.XMLHttpRequest

class TestUtil() {

    //Most Handler Tests are IntegrationTests
    fun isSimpleAppAvailable(): Boolean {
        val xhr = XMLHttpRequest();
        val url = "http://sven:pass@localhost:8080/restful/"
        xhr.open("GET", url, false);
        // xhr.setRequestHeader("Authorization", "Basic $credentials")
        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
        xhr.setRequestHeader("Accept", "application/json")

        try {
            xhr.send(); // there will be a 'pause' here until the response to come.
        } catch (e: Throwable) {
            return false
        }
        console.log("[$url status: ${xhr.status}]")

        val answer = xhr.status.equals(200)

        return answer
    }

    fun login() {
        Session.login("http://localhost:8080/restful/", "sven", "pass")
    }

    fun invokeFixtureScript() {
        val jsonStr = ACTIONS_RUN_FIXTURE_SCRIPT.str
        val action = ActionHandler().parse(jsonStr)
        val l = action.getInvokeLink()!!
        val obs = null //TODO special Observer to be used?
        console.log("[TestUtil.invokeFixtureScript]")
        RoXmlHttpRequest().invoke(l, obs)
    }

}