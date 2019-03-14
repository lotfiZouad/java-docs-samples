/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.healthcare.fhir.resources;

// [START healthcare_search_resources_post]

import com.google.HealthcareQuickstart;
import com.google.api.services.healthcare.v1beta1.CloudHealthcare.Projects.Locations.Datasets.FhirStores.Fhir.SearchResources;
import com.google.api.services.healthcare.v1beta1.model.HttpBody;

import java.io.IOException;

public class FhirResourceSearchPost {
  public static void searchFhirResourcesPost(
      String projectId,
      String cloudRegion,
      String datasetId,
      String fhirStoreId,
      String resourceType) throws IOException {
    String parentName = String.format(
        "projects/%s/locations/%s/datasets/%s/fhirStores/%s",
        projectId,
        cloudRegion,
        datasetId,
        fhirStoreId);
    SearchResources request = HealthcareQuickstart.getCloudHealthcareClient()
        .projects()
        .locations()
        .datasets()
        .fhirStores()
        .fhir()
        .searchResources(parentName, resourceType);
    request.setAccessToken(HealthcareQuickstart.getAccessToken());
    HttpBody httpBody = request.execute();

    System.out.println("FHIR resource search results: " + httpBody.getData());
  }
}
// [END healthcare_search_resources_post]