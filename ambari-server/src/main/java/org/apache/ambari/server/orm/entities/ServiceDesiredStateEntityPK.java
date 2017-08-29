/**
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

package org.apache.ambari.server.orm.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

@SuppressWarnings("serial")
public class ServiceDesiredStateEntityPK implements Serializable {
  private Long clusterId;

  @javax.persistence.Column(name = "cluster_id", nullable = false, insertable = true, updatable = true, length = 10)
  @Id
  public Long getClusterId() {
    return clusterId;
  }

  public void setClusterId(Long clusterId) {
    this.clusterId = clusterId;
  }

  private Long serviceGroupId;

  @Column(name = "service_group_id", nullable = false, insertable = true, updatable = true, length = 10)
  @Id
  public Long getServiceGroupId() {
    return serviceGroupId;
  }

  public void setServiceGroupId(Long serviceGroupId) {
    this.serviceGroupId = serviceGroupId;
  }

  private Long serviceId;

  @Id
  @Column(name = "service_id", nullable = false, insertable = true, updatable = true, length = 10)
  public Long getServiceId() {
    return serviceId;
  }

  public void setServiceId(Long serviceId) {
    this.serviceId = serviceId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ServiceDesiredStateEntityPK that = (ServiceDesiredStateEntityPK) o;

    if (clusterId != null ? !clusterId.equals(that.clusterId) : that.clusterId != null) return false;
    if (serviceGroupId != null ? !serviceGroupId.equals(that.serviceGroupId) : that.serviceGroupId != null) return false;
    if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = clusterId != null ? clusterId.intValue() : 0;
    result = 31 * result + (serviceGroupId != null ? serviceGroupId.hashCode() : 0);
    result = 31 * result + (serviceId != null ? serviceId.hashCode() : 0);
    return result;
  }
}