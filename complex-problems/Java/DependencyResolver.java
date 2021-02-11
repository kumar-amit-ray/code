/**
 * Given a list of version and dependency, find out the install order of the version such that all the
 * non-dependent versions installs first and then the dependent ones.
 */
public class DependencyNode {
    private int version;
    private List<DependencyNode> dependencies;

    public int getVersion() {
        return version;
    }

    public List<DependencyNode> getDependencies() {
        return dependencies;
    }

    public DependencyNode(int version) {
        this.version = version;
        this.dependencies = new ArrayList<>();
    }
    public void addDependency(DependencyNode dependency) {
        this.dependencies.add(dependency);
    }
}

public class DependencyTree {
    DependencyNode root = new DependencyNode(0);
    Map<Integer, DependencyNode> treeHash = new HashMap<>();

    public DependencyNode search(int version) {
        if (treeHash.containsKey(version)) {
            return treeHash.get(version);
        }
        return null;
    }

    public void add(int version, int onVersion) {
        DependencyNode versionNode = search(version);
        DependencyNode onVersionNode = search(onVersion);

        if (versionNode == null) {
            versionNode = new DependencyNode(version);
            root.addDependency(versionNode);
            treeHash.put(version, versionNode);
        }
        if (onVersionNode == null) {
            onVersionNode = new DependencyNode(onVersion);
            treeHash.put(onVersion, onVersionNode);
        }

        if (!versionNode.getDependencies().contains(onVersionNode)) {
            versionNode.addDependency(onVersionNode);
        }
    }

    public List<Integer> buildInstallOrder() {
        List<Integer> result = new ArrayList<>();
        buildInstallOrderRecursive(root, result, new HashSet<>());
        return result;
    }

    private void buildInstallOrderRecursive(DependencyNode node, List<Integer> result, Set<Integer> duplicate) {
        for (DependencyNode depNode : node.getDependencies()) {
            buildInstallOrderRecursive(depNode, result, duplicate);
        }
        if (!node.equals(root) && !duplicate.contains(node.getVersion())) {
            result.add(node.getVersion());
            duplicate.add(node.getVersion());
        }
    }

    public static void main(String[] args) {
        DependencyTree tree = new DependencyTree();

        tree.add(1, 8);
        tree.add(1, 4);
        tree.add(8, 6);
        tree.add(4, 5);
        tree.add(4, 6);
        tree.add(2, 5);
        tree.add(2, 9);
        tree.add(3, 5);
        tree.add(3, 6);
        tree.add(3, 9);
        tree.add(3, 2);

        System.out.println(tree.buildInstallOrder());
    }
}
