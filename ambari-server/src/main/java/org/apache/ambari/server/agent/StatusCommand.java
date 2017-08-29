/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ambari.server.agent;

import java.util.HashMap;
import java.util.Map;

import org.apache.ambari.server.state.State;

import com.google.gson.annotations.SerializedName;

/**
 * Command to report the status of a list of services in roles.
 */
public class StatusCommand extends AgentCommand {

  public StatusCommand() {
    super(AgentCommandType.STATUS_COMMAND);
  }

  @SerializedName("clusterName")
  private String clusterName;

  @SerializedName("serviceName")
  private String serviceName;

  @SerializedName("serviceDisplayName")
  private String serviceDisplayName;

  @SerializedName("componentName")
  private String componentName;

  @SerializedName("configurations")
  private Map<String, Map<String, String>> configurations;

  @SerializedName("configuration_attributes")
  private Map<String, Map<String, Map<String, String>>> configurationAttributes;

  @SerializedName("commandParams")
  private Map<String, String> commandParams = new HashMap<>();

  @SerializedName("hostLevelParams")
  private Map<String, String> hostLevelParams = new HashMap<>();

  @SerializedName("hostname")
  private String hostname = null;

  @SerializedName("payloadLevel")
  private StatusCommandPayload payloadLevel = StatusCommandPayload.DEFAULT;

  @SerializedName("desiredState")
  private State desiredState;

  @SerializedName("hasStaleConfigs")
  private Boolean hasStaleConfigs;

  @SerializedName("executionCommandDetails")
  private ExecutionCommand executionCommand;

  public ExecutionCommand getExecutionCommand() {
    return executionCommand;
  }

  public void setExecutionCommand(ExecutionCommand executionCommand) {
    this.executionCommand = executionCommand;
  }

  public State getDesiredState() {
    return desiredState;
  }

  public void setDesiredState(State desiredState) {
    this.desiredState = desiredState;
  }

  public Boolean getHasStaleConfigs() {
    return hasStaleConfigs;
  }

  public void setHasStaleConfigs(Boolean hasStaleConfigs) {
    this.hasStaleConfigs = hasStaleConfigs;
  }

  public StatusCommandPayload getPayloadLevel() {
    return payloadLevel;
  }

  public void setPayloadLevel(StatusCommandPayload payloadLevel) {
    this.payloadLevel = payloadLevel;
  }

  public String getClusterName() {
    return clusterName;
  }

  public void setClusterName(String clusterName) {
    this.clusterName = clusterName;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public String getServiceDisplayName() { return serviceDisplayName; }

  public void setServiceDisplayName(String serviceDisplayName) {
    this.serviceDisplayName = serviceDisplayName;
  }

  public String getComponentName() {
    return componentName;
  }

  public void setComponentName(String componentName) {
    this.componentName = componentName;
  }

  public Map<String, Map<String, String>> getConfigurations() {
    return configurations;
  }

  public void setConfigurations(Map<String, Map<String, String>> configurations) {
    this.configurations = configurations;
  }

  public Map<String, Map<String, Map<String, String>>> getConfigurationAttributes() {
    return configurationAttributes;
  }

  public void setConfigurationAttributes(Map<String, Map<String, Map<String, String>>> configurationAttributes) {
    this.configurationAttributes = configurationAttributes;
  }

  public Map<String, String> getHostLevelParams() {
    return hostLevelParams;
  }

  public void setHostLevelParams(Map<String, String> params) {
    hostLevelParams = params;
  }

  public Map<String, String> getCommandParams() {
    return commandParams;
  }

  public void setCommandParams(Map<String, String> commandParams) {
    this.commandParams = commandParams;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public String getHostname() {
    return hostname;
  }

  public enum StatusCommandPayload {
    // The minimal payload for status, agent adds necessary details
    MINIMAL,
    // default payload - backward compatible
    DEFAULT,
    // has enough details to construct START or INSTALL commands
    EXECUTION_COMMAND
  }
}
