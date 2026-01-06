public static void main(String[] args) {
        List<DataModel> dataModelList = loadData();
        for (DataModel dataModel : dataModelList) {
            buildRecursively(dataModel);
        }
        nodeMap.forEach((name, dataModel) -> System.out.println(name + " -> " + dataModel));
    }

    private static void buildRecursively(DataModel currNode) {
        String parentId = currNode.getStringValue("parentId");
        String name = currNode.getStringValue("name");

        if (StringUtils.isEmpty(parentId)) {
            nodeMap.put(name, currNode);
            return;
        }

        DataModel parentNode = nodeMap.get(parentId);
        if (parentNode == null) {
            parentNode = new DataModel();
            parentNode.setStringValue("name", parentId);
        }
        List<DataModel> children = (List<DataModel>) parentNode.get("children");
        if (CollectionUtil.isEmpty(children)) {
            children = new ArrayList<>();
        }
        children.add(currNode);
        parentNode.setFieldValue("children", children);

        buildRecursively(parentNode);
    }

    private static final Map<String, DataModel> nodeMap = new HashMap<>();

    private static List<DataModel> loadData() {
        List<DataModel> list = new ArrayList<>();

        DataModel dataModel1 = new DataModel();
        dataModel1.setStringValue("parentId", null);
        dataModel1.setStringValue("name", "node1");
        list.add(dataModel1);

        DataModel dataModel2 = new DataModel();
        dataModel2.setStringValue("parentId", null);
        dataModel2.setStringValue("name", "node2");
        list.add(dataModel2);

        DataModel dataModel3 = new DataModel();
        dataModel3.setStringValue("parentId", null);
        dataModel3.setStringValue("name", "node3");
        list.add(dataModel3);

        DataModel dataModel11 = new DataModel();
        dataModel11.setStringValue("parentId", "node1");
        dataModel11.setStringValue("name", "node11");
        list.add(dataModel11);

        DataModel dataModel12 = new DataModel();
        dataModel12.setStringValue("parentId", "node1");
        dataModel12.setStringValue("name", "node12");
        list.add(dataModel12);

        DataModel dataModel21 = new DataModel();
        dataModel21.setStringValue("parentId", "node2");
        dataModel21.setStringValue("name", "node21");
        list.add(dataModel21);

        DataModel dataModel111 = new DataModel();
        dataModel111.setStringValue("parentId", "node11");
        dataModel111.setStringValue("name", "node111");
        list.add(dataModel111);

        DataModel dataModel112 = new DataModel();
        dataModel112.setStringValue("parentId", "node11");
        dataModel112.setStringValue("name", "node112");
        list.add(dataModel112);

        return list;
    }
