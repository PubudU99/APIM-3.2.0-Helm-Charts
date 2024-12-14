#!/bin/bash

# Define the label selector for the pod
LABEL_SELECTOR="deployment=apim32-am-all-in-one"

# Fetch the pod IP using kubectl
POD_IP=$(kubectl get pods -l $LABEL_SELECTOR -o=jsonpath='{.items[0].status.podIP}')

# Check if the POD_IP was found
if [ -z "$POD_IP" ]; then
  echo "No pod found with the label $LABEL_SELECTOR"
  exit 1
fi

# Define the entries you want to add to /etc/hosts
HOSTS_ENTRY="$POD_IP gw.wso2.com am.wso2.com websocket.wso2.com"

# Update /etc/hosts (you need to have sudo privileges to modify this file)
echo "$HOSTS_ENTRY" | sudo tee -a /etc/hosts > /dev/null

echo "Added the following entry to /etc/hosts:"
echo "$HOSTS_ENTRY"
service_url = "https://localhost:{{ add 9443 .Values.wso2.apim.portOffset }}/services/"

  c8dfa2ca-65d9-45c5-830a-f3c93b1e5d5f

  az role assignment create \
  --assignee 65e190b3-0cab-4ed0-a70b-97d9ae12069f \
  --role "Network Contributor" \
  --scope "/subscriptions/c8dfa2ca-65d9-45c5-830a-f3c93b1e5d5f/resourceGroups/rg-bnymellonprod-cst-prod-westeurope/providers/Microsoft.Network/virtualNetworks/vnet-bnymellonprod-cst-spoke-prod-westeurope-001"

