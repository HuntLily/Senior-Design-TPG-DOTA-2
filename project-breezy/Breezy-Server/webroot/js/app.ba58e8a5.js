(function(t){function e(e){for(var s,i,r=e[0],c=e[1],l=e[2],d=0,v=[];d<r.length;d++)i=r[d],Object.prototype.hasOwnProperty.call(o,i)&&o[i]&&v.push(o[i][0]),o[i]=0;for(s in c)Object.prototype.hasOwnProperty.call(c,s)&&(t[s]=c[s]);u&&u(e);while(v.length)v.shift()();return n.push.apply(n,l||[]),a()}function a(){for(var t,e=0;e<n.length;e++){for(var a=n[e],s=!0,r=1;r<a.length;r++){var c=a[r];0!==o[c]&&(s=!1)}s&&(n.splice(e--,1),t=i(i.s=a[0]))}return t}var s={},o={app:0},n=[];function i(e){if(s[e])return s[e].exports;var a=s[e]={i:e,l:!1,exports:{}};return t[e].call(a.exports,a,a.exports,i),a.l=!0,a.exports}i.m=t,i.c=s,i.d=function(t,e,a){i.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:a})},i.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},i.t=function(t,e){if(1&e&&(t=i(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var a=Object.create(null);if(i.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var s in t)i.d(a,s,function(e){return t[e]}.bind(null,s));return a},i.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return i.d(e,"a",e),e},i.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},i.p="/";var r=window["webpackJsonp"]=window["webpackJsonp"]||[],c=r.push.bind(r);r.push=e,r=r.slice();for(var l=0;l<r.length;l++)e(r[l]);var u=c;n.push([0,"chunk-vendors"]),a()})({0:function(t,e,a){t.exports=a("56d7")},"034f":function(t,e,a){"use strict";var s=a("64a9"),o=a.n(s);o.a},"0590":function(t,e,a){"use strict";var s=a("7aaf"),o=a.n(s);o.a},"0941":function(t,e,a){},"1fbf":function(t,e,a){t.exports=a.p+"img/ros.6c4982d5.png"},"23d2":function(t,e,a){t.exports=a.p+"img/shadowraze_2.a68e5407.png"},"25a5":function(t,e,a){},"35e3":function(t,e,a){t.exports=a.p+"img/shadowraze_1.290a9528.png"},"4dbb":function(t,e,a){"use strict";var s=a("dfeb"),o=a.n(s);o.a},"56d7":function(t,e,a){"use strict";a.r(e);a("cadf"),a("551c"),a("f751"),a("097d");var s=a("2b0e"),o=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{attrs:{id:"app"}},[s("b-container",{staticClass:"background h-100",attrs:{fluid:""}},[s("b-row",{staticClass:"m-5 server-state-general"},[s("b-col",[s("div",{staticClass:"d-flex"},[s("img",{staticClass:"dota-logo",attrs:{src:a("cf05")}}),s("b-container",{attrs:{fluid:""}},[s("b-row",[s("b-col",{staticClass:"d-flex"},[s("h2",{staticClass:"server-state-title"},[t._v("Server State")])])],1),s("b-row",{staticClass:"server-state-details"},[s("b-col",{staticClass:"d-flex justify-content-between"},[s("div",{staticClass:"d-flex flex-column justifiy-content-start text-left"},[s("h4",{staticClass:"text-capitalize"},[t._v("Override Agent Action Codes? "+t._s(t.serverState.overrideAgent))]),s("h4",[t._v("Transmitting Action Code: "+t._s(t.serverState.actionCode))]),s("h4",[t._v("Average Client Latency: "+t._s(t.serverState.averageClientLatency)+"ms")])]),s("div",{staticClass:"ml-5 latency-box"},[t.editDotaBetaFolder?s("div",{staticClass:"d-flex justify-content-between"},[s("b-alert",{staticClass:"alert",attrs:{show:t.showPathValidationError,dismissible:"",variant:"danger"}},[t._v('No spaces are allowed in the dota beta folder path. On windows the command \'dir /x\' will list a space free mnemonic for any folder. Ex: "Program Files (x86)" becomes "PROGRA~2", "dota 2 beta" becomes "DOTA2B~1"')]),s("b-form-input",{model:{value:t.dotaBetaFolderPath,callback:function(e){t.dotaBetaFolderPath=e},expression:"dotaBetaFolderPath"}}),s("span",{on:{click:function(e){return t.editDotaBetaFolderPath()}}},[s("v-icon",{staticClass:"ml-4",attrs:{name:"times"}})],1),s("span",{on:{click:function(e){return t.saveDotaBetaFolderPath()}}},[s("v-icon",{staticClass:"ml-4",attrs:{name:"check"}})],1)],1):s("h4",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"text-left",attrs:{title:"Click to edit"},on:{click:function(e){return t.editDotaBetaFolderPath()}}},[t._v("Dota Beta Folder Path: "+t._s(t.serverState.dotaBetaFolderPath)),s("v-icon",{staticClass:"ml-4",attrs:{name:"pencil-alt"}})],1),s("h4",{staticClass:"text-left"},[t._v("Latency Records:")]),s("div",{staticClass:"d-inline-flex flex-wrap"},t._l(t.serverState.clientLatencyData,(function(e,a){return s("div",{key:a,staticClass:"latency-record"},[t._v("\n                        "+t._s(e)+" \n                        ")])})),0)]),s("div",{staticClass:"text-bottom"},[s("p",{staticClass:"text-right text-bottom"},[t._v("Design by "),s("a",{attrs:{href:"http://arinmac.ca"}},[t._v("arinmac.ca")])])])])],1)],1)],1)])],1),s("b-row",{staticClass:"m-5"},[s("b-col",{attrs:{cols:"8"}},[s("h2",{staticClass:"text-left title"},[t._v("Actions")]),s("div",{staticClass:"outline"},[s("actions-bar",{on:{"server-state-update":t.updateServerState}})],1),s("h2",{staticClass:"text-left title mt-2"},[t._v("Run Control Panel")]),s("div",{staticClass:"outline"},[s("run-control-panel")],1)]),s("b-col",{attrs:{cols:"4"}},[s("h2",{staticClass:"text-left title"},[t._v("Agent Configuration")]),s("div",{staticClass:"outline"},[s("AgentConfig",{on:{serverState:t.updateServerState}})],1)])],1),s("b-row",{staticClass:"m-5"},[s("b-col",{attrs:{cols:"12"}},[s("h2",{staticClass:"text-left title"},[t._v("Features Table")]),s("div",{staticClass:"outline"},[s("VectorTrack")],1)])],1)],1)],1)},n=[],i=(a("6762"),a("2fdb"),a("0874")),r=(a("7224"),a("c52b"),a("c369"),a("ad32")),c=a.n(r),l=a("cc7d"),u=a.n(l),d=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("b-container",{attrs:{fluid:""}},[s("div",{staticClass:"d-flex justify-content-between"},[s("div",{staticClass:"d-flex flex-column justify-content-between"},[s("div",{staticClass:"d-flex flex-column rune-panel"},[s("h3",{staticClass:"panel-title text-uppercase text-left"},[t._v("Get Runes")]),s("div",{staticClass:"d-flex flex-wrap"},t._l(t.runes,(function(e,a){return s("div",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],key:a,staticClass:"action-button-wide m-2",attrs:{title:e.name},on:{click:function(a){return t.setAction(e.code)}}},[0==e.position?s("span",{staticClass:"button-text-rune"},[t._v(t._s(e.name.substring(4,e.name.length)))]):t._e(),1==e.position?s("span",{staticClass:"button-text-rune"},[t._v(t._s(e.name.substring(4,e.name.length)))]):t._e(),2==e.position?s("span",{staticClass:"button-text-rune"},[t._v(t._s(e.name.substring(4,e.name.length)))]):t._e(),3==e.position?s("span",{staticClass:"button-text-rune"},[t._v(t._s(e.name.substring(4,e.name.length)))]):t._e()])})),0)]),s("div",{staticClass:"d-flex flex-column cast-panel"},[s("h3",{staticClass:"panel-title text-uppercase text-left"},[t._v("Cast")]),s("div",{staticClass:"d-flex flex-wrap"},t._l(t.cast,(function(e,o){return s("div",{key:o,staticClass:"action-button-cast m-2",on:{click:function(a){return t.setAction(e.code)}}},[0==e.position?s("b-img",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"button-img",attrs:{title:"Cast Shadow Raze 1 (Near)",src:a("35e3")}}):t._e(),1==e.position?s("b-img",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"button-img",attrs:{title:"Cast Shadow Raze 2 (Medium)",src:a("23d2")}}):t._e(),2==e.position?s("b-img",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"button-img",attrs:{title:"Cast Shadow Raze 1 (Far)",src:a("e0ec")}}):t._e(),3==e.position?s("b-img",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"button-img",attrs:{title:"Cast Requiem of Souls",src:a("1fbf")}}):t._e(),4==e.position?s("b-img",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"button-img",attrs:{title:"Use Salve",src:a("828c")}}):t._e()],1)})),0)])]),s("div",{staticClass:"d-flex flex-column attack-creep-panel"},[s("h3",{staticClass:"panel-title text-uppercase text-left"},[t._v("Attack Creep")]),s("div",{staticClass:"d-flex flex-wrap"},t._l(t.attackCreep,(function(e,a){return s("div",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],key:a,staticClass:"action-button m-2",attrs:{title:e.name},on:{click:function(a){return t.setAction(e.code)}}},[e.position<10?s("span",{staticClass:"button-number"},[t._v(t._s(e.position))]):t._e(),10==e.position?s("div",{staticClass:"button-text"},[t._v(t._s(e.name))]):t._e(),11==e.position?s("span",{staticClass:"button-number"},[t._v("0")]):t._e(),12==e.position?s("div",{staticClass:"button-text"},[t._v(t._s(e.name))]):t._e()])})),0)]),s("div",{staticClass:"d-flex flex-column move-panel"},[s("h3",{staticClass:"panel-title text-uppercase text-left"},[t._v("Move")]),s("div",{staticClass:"d-flex flex-wrap"},t._l(t.move,(function(e,a){return s("div",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],key:a,staticClass:"action-button m-2 ",attrs:{title:e.name},on:{click:function(a){return t.setAction(e.code)}}},["MOVE_N"==e.action?s("v-icon",{staticClass:"button-icon north",attrs:{name:"arrow-up",scale:"3"}}):t._e(),"MOVE_NE"==e.action?s("v-icon",{staticClass:"button-icon",attrs:{name:"arrow-right",scale:"3"}}):t._e(),"MOVE_NW"==e.action?s("v-icon",{staticClass:"button-icon",attrs:{name:"arrow-up",scale:"3"}}):t._e(),"MOVE_W"==e.action?s("v-icon",{staticClass:"button-icon west",attrs:{name:"arrow-up",scale:"3"}}):t._e(),"MOVE_E"==e.action?s("v-icon",{staticClass:"button-icon east",attrs:{name:"arrow-up",scale:"3"}}):t._e(),"MOVE_S"==e.action?s("v-icon",{staticClass:"button-icon south",attrs:{name:"arrow-up",scale:"3"}}):t._e(),"MOVE_SE"==e.action?s("v-icon",{staticClass:"button-icon",attrs:{name:"arrow-down",scale:"3"}}):t._e(),"MOVE_SW"==e.action?s("v-icon",{staticClass:"button-icon",attrs:{name:"arrow-left",scale:"3"}}):t._e(),"DO_NOTHING"==e.action?s("v-icon",{staticClass:"button-icon",attrs:{name:"ban",scale:"3"}}):t._e()],1)})),0)])])])},v=[],p=(a("55dd"),a("af12"),a("0ccf"),a("4997"),a("e135"),a("6436"),a("bc3a")),f=a.n(p),h={name:"ActionsBar",components:{"v-icon":i["a"]},data:function(){return{actions:[]}},mounted:function(){var t=this;f.a.get("http://localhost:8085/action/").then((function(e){t.actions=e.data})).catch((function(t){console.log("Error fetching actions from server!")}))},computed:{runes:function(){for(var t=[],e=0;e<this.actions.length;e++){var a=this.actions[e];if(a.action.includes("RUNE")){switch(a.action){case"GET_BOUNTY_RUNE_1":a.position=0;break;case"GET_TOP_POWERUP_RUNE":a.position=1;break;case"GET_BOUNTY_RUNE_3":a.position=2;break;case"GET_BOTTOM_POWERUP_RUNE":a.position=3;break}t.push(a)}}return t.sort((function(t,e){return t.position-e.position})),t},attackCreep:function(){for(var t=[],e=0;e<this.actions.length;e++){var a=this.actions[e];if(a.action.includes("ATTACK_CREEP")||a.action.includes("ATTACK_ENEMY")){switch(a.action){case"ATTACK_CREEP_1":a.position=1;break;case"ATTACK_CREEP_2":a.position=2;break;case"ATTACK_CREEP_3":a.position=3;break;case"ATTACK_CREEP_4":a.position=4;break;case"ATTACK_CREEP_5":a.position=5;break;case"ATTACK_CREEP_6":a.position=6;break;case"ATTACK_CREEP_7":a.position=7;break;case"ATTACK_CREEP_8":a.position=8;break;case"ATTACK_CREEP_9":a.position=9;break;case"ATTACK_ENEMY_HERO":a.position=10;break;case"ATTACK_CREEP_0":a.position=11;break;case"ATTACK_ENEMY_TOWER":a.position=12;break}t.push(a)}}return t.sort((function(t,e){return t.position-e.position})),t},cast:function(){for(var t=[],e=0;e<this.actions.length;e++){var a=this.actions[e];if(a.action.includes("CAST")||a.action.includes("USE_SALVE")){switch(a.action){case"CAST_SHADOWRAZE_1":a.position=0;break;case"CAST_SHADOWRAZE_2":a.position=1;break;case"CAST_SHADOWRAZE_3":a.position=2;break;case"CAST_REQUIEM_OF_SOULS":a.position=3;break;case"USE_SALVE":a.position=4;break}t.push(a)}}return t.sort((function(t,e){return t.position-e.position})),t},move:function(){for(var t=[],e=0;e<this.actions.length;e++){var a=this.actions[e];if(a.action.includes("MOVE")||a.action.includes("DO_NOTHING")){switch(a.action){case"MOVE_NW":a.position=1;break;case"MOVE_N":a.position=2;break;case"MOVE_NE":a.position=5;break;case"MOVE_W":a.position=0;break;case"DO_NOTHING":a.position=4;break;case"MOVE_E":a.position=8;break;case"MOVE_SW":a.position=3;break;case"MOVE_S":a.position=6;break;case"MOVE_SE":a.position=7;break}t.push(a)}}return t.sort((function(t,e){return t.position-e.position})),t}},methods:{setAction:function(t){var e=this;f.a.get("http://localhost:8085/action?value="+t).then((function(t){e.$emit("server-state-update",t.data)}))}}},m=h,b=(a("6edc"),a("2877")),_=Object(b["a"])(m,d,v,!1,null,"76f8145b",null),C=_.exports,g=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("b-container",{attrs:{fluid:""}},[a("b-list-group",{attrs:{flush:""}},[a("b-list-group-item",{staticClass:"widget p-0 pb-4 separator"},[a("b-container",{attrs:{fluid:""}},[a("b-row",[a("b-col",{staticClass:"text-left text-uppercase",attrs:{cols:"12"}},[a("span",{staticClass:"panel-title"},[t._v("Active Configuration")])])],1),a("b-row",{staticClass:"mt-2"},[a("b-col",{attrs:{cols:"3"}},[a("div",{staticClass:"text-right"},[t._v("Host")])]),a("b-col",{staticClass:"text-left p-0",attrs:{cols:"9"}},[t._v("\r\n                        "+t._s(t.host)+"\r\n                    ")])],1),a("b-row",{staticClass:"mt-2"},[a("b-col",{attrs:{cols:"3"}},[a("div",{staticClass:"text-right"},[t._v("Port")])]),a("b-col",{staticClass:"text-left p-0",attrs:{cols:"9"}},[t._v("\r\n                        "+t._s(t.port)+"\r\n                    ")])],1),a("b-row",{staticClass:"mt-2"},[a("b-col",{attrs:{cols:"3"}},[a("div",{staticClass:"text-right"},[t._v("Connect Route")])]),a("b-col",{staticClass:"text-left p-0",attrs:{cols:"9"}},[t._v("\r\n                        "+t._s(t.connectRoute)+"\r\n                    ")])],1),a("b-row",{staticClass:"mt-2"},[a("b-col",{attrs:{cols:"3"}},[a("div",{staticClass:"text-right"},[t._v("Relay Route")])]),a("b-col",{staticClass:"text-left p-0",attrs:{cols:"9"}},[t._v("\r\n                        "+t._s(t.relayRoute)+"\r\n                    ")])],1),a("b-row",{staticClass:"mt-2"},[a("b-col",{attrs:{cols:"3"}},[a("div",{staticClass:"text-right"},[t._v("Run Update Route")])]),a("b-col",{staticClass:"text-left p-0",attrs:{cols:"9"}},[t._v("\r\n                        "+t._s(t.runUpdateRoute)+"\r\n                    ")])],1),a("b-row",{staticClass:"mt-2"},[a("b-col",{attrs:{cols:"3"}},[a("div",{staticClass:"text-right"},[t._v("Status")])]),a("b-col",{staticClass:"text-left",attrs:{cols:"9"}},[a("v-icon",{directives:[{name:"show",rawName:"v-show",value:t.connected,expression:"connected"}],staticClass:"text-success",attrs:{name:"check-circle"}}),a("v-icon",{directives:[{name:"show",rawName:"v-show",value:!t.connected,expression:"!connected"}],staticClass:"text-danger",attrs:{name:"exclamation-circle"}})],1)],1)],1)],1),a("b-list-group-item",{staticClass:"widget p-0 pt-4"},[a("b-container",{attrs:{fluid:""}},[a("b-row",{staticClass:"mt-2"},[a("b-col",{attrs:{cols:"3"}},[a("div",{staticClass:"text-right"},[t._v("Host")])]),a("b-col",{staticClass:"text-left p-0",attrs:{cols:"9"}},[a("b-form-input",{model:{value:t.hostInput,callback:function(e){t.hostInput=e},expression:"hostInput"}})],1)],1),a("b-row",{staticClass:"mt-2"},[a("b-col",{attrs:{cols:"3"}},[a("div",{staticClass:"text-right"},[t._v("Port")])]),a("b-col",{staticClass:"text-left p-0",attrs:{cols:"9"}},[a("b-form-input",{model:{value:t.portInput,callback:function(e){t.portInput=e},expression:"portInput"}})],1)],1),a("b-row",{staticClass:"mt-2"},[a("b-col",{attrs:{cols:"3"}},[a("div",{staticClass:"text-right"},[t._v("Connect Route")])]),a("b-col",{staticClass:"text-left p-0",attrs:{cols:"9"}},[a("b-form-input",{model:{value:t.connectRouteInput,callback:function(e){t.connectRouteInput=e},expression:"connectRouteInput"}})],1)],1),a("b-row",{staticClass:"mt-2"},[a("b-col",{attrs:{cols:"3"}},[a("div",{staticClass:"text-right"},[t._v("Relay Route")])]),a("b-col",{staticClass:"text-left p-0",attrs:{cols:"9"}},[a("b-form-input",{model:{value:t.relayRouteInput,callback:function(e){t.relayRouteInput=e},expression:"relayRouteInput"}})],1)],1),a("b-row",{staticClass:"mt-2"},[a("b-col",{attrs:{cols:"3"}},[a("div",{staticClass:"text-right"},[t._v("Run Update Route")])]),a("b-col",{staticClass:"text-left p-0",attrs:{cols:"9"}},[a("b-form-input",{model:{value:t.runUpdateRouteInput,callback:function(e){t.runUpdateRouteInput=e},expression:"runUpdateRouteInput"}})],1)],1),a("b-row",{staticClass:"mt-4"},[a("b-col",[a("b-btn",{staticClass:"agent-button m-2",on:{click:t.testConfig}},[t._v("Test \r\n                            "),a("v-icon",{directives:[{name:"show",rawName:"v-show",value:t.testLoading,expression:"testLoading"}],attrs:{name:"spinner",spin:""}}),a("v-icon",{directives:[{name:"show",rawName:"v-show",value:t.showTestResult&&t.testResult,expression:"showTestResult && testResult"}],staticClass:"text-success",attrs:{name:"check-circle"}}),a("v-icon",{directives:[{name:"show",rawName:"v-show",value:t.showTestResult&&!t.testResult,expression:"showTestResult && !testResult"}],staticClass:"text-danger",attrs:{name:"exclamation-circle"}})],1),a("b-btn",{staticClass:"agent-button m-2",on:{click:t.updateConfig}},[t._v("Confirm")]),a("b-btn",{staticClass:"agent-button m-2",on:{click:function(e){return t.agentOverride(!0)}}},[t._v("Override Agent Action Codes")]),a("b-btn",{staticClass:"agent-button m-2",on:{click:function(e){return t.agentOverride(!1)}}},[t._v("Use Agent Action Codes")])],1)],1)],1)],1)],1)],1)},x=[],w=(a("c5f6"),a("7338"),a("d88a"),a("fb39"),{name:"AgentConfig",components:{"v-icon":i["a"]},data:function(){return{hostInput:"localhost",portInput:"8086",connectRouteInput:"/",relayRouteInput:"/",runUpdateRouteInput:"/",connected:!1,host:"",port:"",connectRoute:"",relayRoute:"",runUpdateRoute:"",testResult:!1,showTestResult:!1,testLoading:!1}},watch:{hostInput:function(){this.showTestResult=!1},portInput:function(){this.showTestResult=!1},connectRouteInput:function(){this.showTestResult=!1},relayRouteInput:function(){this.showTestResult=!1}},mounted:function(){var t=this;f.a.get("http://localhost:8085/agent/config").then((function(e){t.host=e.data.host,t.port=e.data.port,t.connectRoute=e.data["connect.route"],t.relayRoute=e.data["relay.route"],t.runUpdateRoute=e.data["run.update.route"],t.connected=e.data.connected}))},methods:{updateConfig:function(){var t=this,e={port:Number(t.portInput),host:t.hostInput};e["connect.route"]=t.connectRouteInput,e["relay.route"]=t.relayRouteInput,e["run.update.route"]=t.runUpdateRouteInput,f.a.post("http://localhost:8085/agent/config",e).then((function(e){t.host=e.data.host,t.port=e.data.port,t.connectRoute=e.data["connect.route"],t.relayRoute=e.data["relay.route"],t.updateRunRoute=e.data["run.update.route"],t.connected=e.data.connected})).catch((function(t){console.log("Error updating agent config!"),console.log(t)}))},testConfig:function(){var t=this;t.testLoading=!0;var e={port:Number(t.portInput),host:t.hostInput};e["connect.route"]=t.connectRouteInput,e["relay.route"]=t.relayRouteInput,e["run.update.route"]=t.runUpdateRouteInput,f.a.post("http://localhost:8085/agent/config/test",e).then((function(e){console.log(e.data),t.testLoading=!1,t.testResult=e.data.connected,t.showTestResult=!0})).catch((function(e){t.testLoading=!1,t.testResult=!1,t.showTestResult=!0,console.log("Error testing agent config!"),console.log(e)}))},agentOverride:function(t){var e=this;f.a.get("http://localhost:8085/agent?override="+t).then((function(t){console.log(t.data),e.$emit("serverState",t.data)}))}}}),R=w,y=(a("c66c"),Object(b["a"])(R,g,x,!1,null,"375c08e2",null)),A=y.exports,E=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("b-container",{attrs:{fluid:""}},[a("b-row",[a("b-col",[a("p",[t._v("Viewing last "+t._s(t.windowSize)+" feature vectors")]),a("div",{staticClass:"d-flex justify-content-center"},[a("label",{attrs:{for:"range-2"}},[t._v("Adjust the feature stream window size with this slider: ")]),a("b-form-input",{staticClass:"stream-window-slider ml-2",attrs:{id:"range-2",type:"range",min:"1",max:"10",step:"1"},model:{value:t.windowSize,callback:function(e){t.windowSize=e},expression:"windowSize"}})],1),a("p",{staticClass:"text-left w-50 para"},[t._v("The Dota 2 connector throttles front end feature stream updates such that 1 feature vector is sent every 1500ms. This ensures this page remains responsive while getting near real time updates.\n        Actual dota 2 client latency is displayed in the server status, and is unrelated to the 1500ms delay in updating the table below. This means you'll likely continue to see updates here after your run \n        has terminated, they will continue until all feature vectors from the run are streamed to this page.\n        A wider window displays additional data but may result in degraded performance in the browser. \n        This does not affect the game, or agent vector-action code transmission just the responsiveness of this page in your browser.")])])],1),a("b-row",[a("b-col",[a("div",{staticClass:"track-container w-100 d-flex"},[a("b-container",{staticClass:"legend track-element flex-fill",attrs:{fluid:""}},[a("b-row",{staticClass:"time text-uppercase"},[a("b-col",[t._v("\n              "+t._s(void 0!==t.featureMap[56]?t.featureMap[56].name:"")+"\n            ")])],1),t._l(t.featureMap,(function(e,s){return a("b-row",{key:s,staticClass:"text-values"},[a("b-col",[t._v("\n              "+t._s(e.name)+"\n            ")])],1)}))],2),t._l(t.featureVectors,(function(e,s){return a("b-container",{key:s,staticClass:"track-element flex-fill",attrs:{fluid:""}},[a("b-row",{staticClass:"time"},[a("b-col",[t._v("\n              "+t._s(e[56])+"\n            ")])],1),t._l(e,(function(e,o){return a("b-row",{key:o,staticClass:"text-values"},[a("b-col",{staticClass:"vector-item"},[a("span",{staticClass:"value"},[t._v(t._s(e))]),a("span",{staticClass:"delta"},[void 0!==t.featureVectors[s-1]&&e-t.featureVectors[s-1][o]>0?a("v-icon",{staticStyle:{color:"green"},attrs:{name:"arrow-up"}}):t._e(),void 0!==t.featureVectors[s-1]&&e-t.featureVectors[s-1][o]<0?a("v-icon",{staticStyle:{color:"red"},attrs:{name:"arrow-down"}}):t._e(),t._v("\n              "+t._s(t.featureVectors[s-1]&&e-t.featureVectors[s-1][o]!==0?e-t.featureVectors[s-1][o]:"")+"\n              ")],1)])],1)}))],2)}))],2)])],1)],1)},T=[],k=a("d8d6"),S=a.n(k),O=S.a.prototype._start;S.a.prototype._start=function(t,e,a,s){return s||(s={noCredentials:!0}),O.call(this,t,e,a,s)};var N={name:"VectorTrack",components:{"v-icon":i["a"]},data:function(){return{eb:{},featureVectors:[],featureMap:[],timeouts:[],lastUpdate:void 0,windowSize:5}},beforeCreate:function(){var t=this;f.a.get("http://localhost:8085/features/").then((function(e){t.featureMap=e.data}));var e=new u.a("http://localhost:8085/stream/features");e.onopen=function(){console.log("socket open")},e.onmessage=function(e){if(void 0!==t.lastUpdate){var a=(new Date).getTime(),s=a-t.lastUpdate;console.log(s+"ms"),t.lastUpdate=a}else t.lastUpdate=(new Date).getTime();console.log(e.data);var o=JSON.parse(e.data);t.featureVectors.push(o);while(t.featureVectors.length>t.windowSize)t.featureVectors.shift()},e.onclose=function(){console.log("socket closed")}},methods:{hoverItem:function(t){console.log("woah")}}},I=N,P=(a("4dbb"),Object(b["a"])(I,E,T,!1,null,"2aaf838e",null)),V=P.exports,U=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("b-container",{attrs:{fluid:""}},[a("b-alert",{attrs:{variant:"warning",show:t.activeRunAlreadyExistsAlert,dismissible:""}},[t._v("Cannot start run, there's already an active run!")]),a("b-alert",{attrs:{variant:"warning",show:t.noActiveRunToCancelAlert,dismissible:""}},[t._v("Cannot cancel run, there's no active run to cancel!")]),a("b-row",[a("b-col",{attrs:{cols:"3"}},[a("div",{staticClass:"d-flex flex-column"},[a("div",{staticClass:"d-flex"},[a("div",{staticClass:"action-button action-start",on:{click:t.startRun}},[a("p",{staticClass:"button-text"},[t._v("Start Run")])]),a("div",{staticClass:"d-flex flex-column"},[a("label",{attrs:{for:"run-size"}},[t._v("# of games:")]),a("b-form-input",{staticClass:"ml-2 start-run-input",attrs:{id:"run-size",type:"number",min:"1"},model:{value:t.startRunSize,callback:function(e){t.startRunSize=e},expression:"startRunSize"}})],1)]),a("div",{staticClass:"d-flex mt-2"},[a("div",{staticClass:"action-button action-cancel",on:{click:t.cancelRun}},[a("p",{staticClass:"button-text"},[t._v("Cancel Run")])])]),a("div",{staticClass:"d-flex mt-2"},[a("div",{staticClass:"action-button action-restart",on:{click:t.restartRun}},[a("p",{staticClass:"button-text"},[t._v("Restart Run")])])])])]),a("b-col",{attrs:{cols:"9"}},[void 0!==t.activeRun?a("div",{staticClass:"d-flex flex-column"},[a("h2",{staticClass:"text-left panel-title"},[t._v("Active Run")]),a("b-progress",{attrs:{max:t.activeRun.size,"show-progress":"",animated:""}},[a("b-progress-bar",{attrs:{value:t.activeRun.progress,label:(t.activeRun.progress/t.activeRun.size*100).toFixed(0)+"%"}})],1),void 0!==t.activeRun.error?a("div",{staticClass:"d-flex"},[a("h3",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"text-left run-property",attrs:{title:"Pseudo unique id of the current game"}},[t._v("error:")]),a("p",{staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.error))])]):t._e(),void 0!==t.activeRun.activeGameId?a("div",{staticClass:"d-flex"},[a("h3",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"text-left run-property",attrs:{title:"Pseudo unique id of the current game"}},[t._v("activeGameId:")]),a("p",{staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.activeGameId))])]):t._e(),void 0!==t.activeRun.duration?a("div",{staticClass:"d-flex"},[a("h3",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"text-left run-property",attrs:{title:"Time since the start of the run in milliseconds"}},[t._v("duration:")]),a("p",{staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.duration)+" ms")])]):t._e(),void 0!==t.activeRun.gameIds?a("div",{staticClass:"d-flex"},[a("h3",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"text-left run-property",attrs:{title:"Ids of completed games in this run"}},[t._v("gameIds:")]),t._l(t.activeRun.gameIds,(function(e,s){return a("p",{key:s,staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.gameIds[s]))])}))],2):t._e(),void 0!==t.activeRun.crashedGames?a("div",{staticClass:"d-flex"},[a("h3",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"text-left run-property",attrs:{title:"Ids of crashed games in this run"}},[t._v("crashedGames:")]),t._l(t.activeRun.crashedGames,(function(e,s){return a("p",{key:s,staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.crashedGames[s]))])}))],2):t._e(),void 0!==t.activeRun.id?a("div",{staticClass:"d-flex"},[a("h3",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"text-left run-property",attrs:{title:"UUID of this run"}},[t._v("id:")]),a("p",{staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.id))])]):t._e(),void 0!==t.activeRun.progress?a("div",{staticClass:"d-flex"},[a("h3",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"text-left run-property",attrs:{title:"Number of completed games so far"}},[t._v("progress:")]),a("p",{staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.progress))])]):t._e(),void 0!==t.activeRun.size?a("div",{staticClass:"d-flex"},[a("h3",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"text-left run-property",attrs:{title:"Total number of games to play in this run"}},[t._v("size:")]),a("p",{staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.size))])]):t._e(),void 0!==t.activeRun.startTime?a("div",{staticClass:"d-flex"},[a("h3",{staticClass:"text-left run-property"},[t._v("startTime:")]),a("p",{staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.startTime))])]):t._e(),void 0!==t.activeRun.status?a("div",{staticClass:"d-flex"},[a("h3",{staticClass:"text-left run-property"},[t._v("status:")]),a("p",{staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.status))])]):t._e(),void 0!==t.activeRun.endTime?a("div",{staticClass:"d-flex"},[a("h3",{staticClass:"text-left run-property"},[t._v("endTime:")]),a("p",{staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.endTime))])]):t._e(),void 0!==t.activeRun.webhook?a("div",{staticClass:"d-flex"},[a("h3",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"text-left run-property",attrs:{title:"Webhook URI that must be hit by a Breezy Agent to proceed to the next game in the run"}},[t._v("webhook:")]),a("p",{staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.webhook))])]):t._e(),void 0!==t.activeRun.winner?a("div",{staticClass:"d-flex"},[a("h3",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"text-left run-property",attrs:{title:"The team that one the last game"}},[t._v("winner:")]),a("p",{staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.winner))])]):t._e(),void 0!==t.activeRun.direKills?a("div",{staticClass:"d-flex"},[a("h3",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"text-left run-property",attrs:{title:"The number of kills the Dire team achieved last game"}},[t._v("direKills:")]),a("p",{staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.direKills))])]):t._e(),void 0!==t.activeRun.radiantKills?a("div",{staticClass:"d-flex"},[a("h3",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"text-left run-property",attrs:{title:"The number of kills the Radiant team achieved last game"}},[t._v("radiantKills:")]),a("p",{staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.radiantKills))])]):t._e(),void 0!==t.activeRun.deaths?a("div",{staticClass:"d-flex"},[a("h3",{directives:[{name:"b-tooltip",rawName:"v-b-tooltip.hover",modifiers:{hover:!0}}],staticClass:"text-left run-property",attrs:{title:"The number of deaths the AI controlled bot suffered last game"}},[t._v("deaths:")]),a("p",{staticClass:"text-left run-property-value ml-2"},[t._v(t._s(t.activeRun.deaths))])]):t._e()],1):t._e()])],1)],1)},M=[],z={name:"RunControlPanel",data:function(){return{activeRun:void 0,startRunSize:1,activeRunAlreadyExistsAlert:!1,noActiveRunToCancelAlert:!1}},beforeCreate:function(){var t=this,e=new c.a("http://localhost:8085/eventbus/");e.onopen=function(){e.registerHandler("sentry.activeRun",(function(e,a){t.activeRun=a.body,console.log("active run data updated!")}))}},mounted:function(){var t=this;f.a.get("http://localhost:8085/run/active").then((function(e){console.log(e),t.activeRun=e.data})).catch((function(e){404===e.response.status&&(t.activeRun=e.response.data)}))},methods:{getActiveRun:function(t){var e=this;f.a.get("http://localhost:8085/run/active").then((function(a){e.activeRun=a.data,t&&t()})).catch((function(a){404===a.response.status&&(e.activeRun=a.response.data,t&&t())}))},startRun:function(t){var e=this;e.activeRunAlreadyExistsAlert=!1,e.noActiveRunToCancelAlert=!1;var a={size:parseInt(e.startRunSize),agent:"Sentry"};f.a.post("http://localhost:8085/run/",a).then((function(a){e.activeRun=a.data,t&&t()})).catch((function(t){void 0!==t.response&&void 0!=t.response.data.error&&t.response.data.error.includes("there already is an active run!")&&(e.activeRunAlreadyExistsAlert=!0)}))},cancelRun:function(t){var e=this;e.activeRunAlreadyExistsAlert=!1,e.noActiveRunToCancelAlert=!1,f.a.delete("http://localhost:8085/run/active").then((function(a){e.activeRun=a.data,t&&t()})).catch((function(t){console.log(t),console.log(t.response),void 0!==t.response&&void 0!=t.response.data.error&&t.response.data.error.includes("No active run!")&&(e.noActiveRunToCancelAlert=!0)}))},restartRun:function(){var t=this;t.getActiveRun((function(){void 0!==t.activeRun.error?t.startRun():(console.log("run already exists, cancelling then starting"),t.cancelRun((function(){setTimeout(t.startRun(),500)})))}))}}},B=z,F=(a("0590"),Object(b["a"])(B,U,M,!1,null,"9c3fe80e",null)),D=F.exports,j=(a("f9e3"),a("2dd8"),{name:"app",components:{VectorTrack:V,"actions-bar":C,AgentConfig:A,"v-icon":i["a"],"run-control-panel":D},data:function(){return{serverState:{actionCode:-1},editDotaBetaFolder:!1,dotaBetaFolderPath:"",showPathValidationError:!1}},beforeCreate:function(){var t=this,e=new c.a("http://localhost:8085/eventbus/");e.onopen=function(){console.log(e),e.registerHandler("sentry.latency",(function(e,a){t.serverState=a.body,console.log("Latency updated")}))}},mounted:function(){var t=this;f.a.get("http://localhost:8085/state/").then((function(e){t.serverState=e.data}))},methods:{updateServerState:function(t){this.serverState=t},editDotaBetaFolderPath:function(){console.log("woah"),this.showPathValidationError=!1,this.editDotaBetaFolder=!this.editDotaBetaFolder,this.dotaBetaFolderPath=this.serverState.dotaBetaFolderPath},saveDotaBetaFolderPath:function(){var t=this;t.showPathValidationError=!1,this.dotaBetaFolderPath.includes(" ")?this.showPathValidationError=!0:f.a.post("http://localhost:8085/state",{dotaBetaFolderPath:t.dotaBetaFolderPath}).then((function(e){t.serverState=e.data,t.editDotaBetaFolder=!1})).catch((function(t){console.log("Error updating server state")}))}}}),K=j,G=(a("034f"),Object(b["a"])(K,o,n,!1,null,null,null)),L=G.exports,W=a("5f5b");s["default"].config.productionTip=!1,s["default"].use(W["a"]),new s["default"]({render:function(t){return t(L)}}).$mount("#app")},"64a9":function(t,e,a){},"6edc":function(t,e,a){"use strict";var s=a("25a5"),o=a.n(s);o.a},"7aaf":function(t,e,a){},"828c":function(t,e,a){t.exports=a.p+"img/salve.9233b499.png"},c66c:function(t,e,a){"use strict";var s=a("0941"),o=a.n(s);o.a},cf05:function(t,e,a){t.exports=a.p+"img/logo.848b9045.png"},dfeb:function(t,e,a){},e0ec:function(t,e,a){t.exports=a.p+"img/shadowraze_3.2ff26419.png"}});
//# sourceMappingURL=app.ba58e8a5.js.map